package com.gexingw.mall.auth.starter;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 16:52
 */
@EnableDubbo(scanBasePackages = {"com.gexingw.mall.auth"})
@MapperScan(basePackages = {"com.gexingw.mall.auth.**.db"})
@SpringBootApplication(scanBasePackages = {"com.gexingw.mall.auth", "com.gexingw.mall.common"})
public class MallAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAuthApplication.class, args);
    }

}
