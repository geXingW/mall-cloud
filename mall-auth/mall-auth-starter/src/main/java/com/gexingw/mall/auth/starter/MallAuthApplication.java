package com.gexingw.mall.auth.starter;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 16:52
 */
@EnableJpaRepositories(basePackages = {"com.gexingw.mall.auth"})
@EntityScan(basePackages = {"com.gexingw.mall.auth"})
@EnableDubbo(scanBasePackages = {"com.gexingw.mall.auth"})
@SpringBootApplication(scanBasePackages = {"com.gexingw.mall.auth", "com.gexingw.mall.common"})
public class MallAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAuthApplication.class, args);
    }

}
