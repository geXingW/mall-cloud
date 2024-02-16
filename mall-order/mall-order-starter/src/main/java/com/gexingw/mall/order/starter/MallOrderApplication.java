package com.gexingw.mall.order.starter;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 15:32
 */
@EnableDubbo(scanBasePackages = {"com.gexingw.mall.order"})
@MapperScan(basePackages = {"com.gexingw.mall.order.**.db"})
@SpringBootApplication(scanBasePackages = {"com.gexingw.mall.order", "com.gexingw.mall.common"})
public class MallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallOrderApplication.class, args);
    }

}
