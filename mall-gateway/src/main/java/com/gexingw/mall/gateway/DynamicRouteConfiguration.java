package com.gexingw.mall.gateway;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.fastjson2.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/21 13:36
 */
@Slf4j
@Configuration
public class DynamicRouteConfiguration {

    private final NacosConfigProperties nacosConfigProperties;
    private final RouteDefinitionWriter routeDefinitionWriter;

    public DynamicRouteConfiguration(NacosConfigProperties nacosConfigProperties, RouteDefinitionWriter routeDefinitionWriter) throws NacosException {
        this.nacosConfigProperties = nacosConfigProperties;
        this.routeDefinitionWriter = routeDefinitionWriter;

        // 注册路由更新方法
        routeListener();
    }

    private void routeListener() throws NacosException {
        String dataId = nacosConfigProperties.getName() + "-routes.json";
        String group = nacosConfigProperties.getGroup();

        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, nacosConfigProperties.getServerAddr());
        properties.setProperty(PropertyKeyConst.NAMESPACE, nacosConfigProperties.getNamespace());
        properties.setProperty(PropertyKeyConst.NAMESPACE, nacosConfigProperties.getNamespace());

        ConfigService configService = NacosFactory.createConfigService(properties);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                log.info("获取到Nacos路由配置信息：{}", configInfo);
                List<RouteDefinition> routeDefinitions = JSON.parseArray(configInfo, RouteDefinition.class);
                updateRoutes(routeDefinitions);
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });
        String configInfo = configService.getConfig(dataId, group, 5000);
        if (configInfo != null) {
            log.debug("获取到Nacos路由配置信息：{}", configInfo);
            List<RouteDefinition> routeDefinitions = JSON.parseArray(configInfo, RouteDefinition.class);
            updateRoutes(routeDefinitions);
        }
    }

    /**
     * 更新路由
     *
     * @param routes 路由信息
     */
    public void updateRoutes(List<RouteDefinition> routes) {
        routes.forEach(route -> {
            try {
                this.routeDefinitionWriter.delete(Mono.just(route.getId())).subscribe();
            } catch (Exception e) {
                log.error("网关路由更新异常：路由删除异常！{}", JSON.toJSONString(route), e);
            }

            try {
                routeDefinitionWriter.save(Mono.just(route)).subscribe();
            } catch (Exception e) {
                log.error("网关路由更新异常：路由保存异常！{}", JSON.toJSONString(route), e);
            }
        });
    }

}
