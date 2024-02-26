package com.gexingw.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/21 13:06
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.gexingw.mall.common", "com.gexingw.mall.gateway"})
public class MallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallGatewayApplication.class, args);
    }

}
