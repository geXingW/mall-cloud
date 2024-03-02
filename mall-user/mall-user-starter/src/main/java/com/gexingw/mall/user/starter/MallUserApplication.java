package com.gexingw.mall.user.starter;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mall-user
 *
 * @author GeXingW
 */
@EnableDubbo(scanBasePackages = {"com.gexingw.mall.user"})
@MapperScan(basePackages = {"com.gexingw.mall.user.**.db"})
@SpringBootApplication(scanBasePackages = {"com.gexingw.mall.user"})
public class MallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallUserApplication.class, args);
    }

}
