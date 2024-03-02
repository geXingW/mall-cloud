package com.gexingw.mall.product.starter;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/29 13:59
 */
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.gexingw.mall.product", "com.gexingw.mall.common"})
public class MallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductApplication.class, args);
    }

}
