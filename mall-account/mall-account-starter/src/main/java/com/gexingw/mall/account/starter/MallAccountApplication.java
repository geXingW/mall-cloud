package com.gexingw.mall.account.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/21 17:27
 */
@SpringBootApplication(scanBasePackages = {"com.gexingw.mall.account", "com.gexingw.mall.common"})
public class MallAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAccountApplication.class, args);
    }

}
