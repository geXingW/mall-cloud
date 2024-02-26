package com.gexingw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/24 10:30
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.gexingw.mall.product", "com.gexingw.mall.common"})
public class MallProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallProductApplication.class, args);
    }
}
