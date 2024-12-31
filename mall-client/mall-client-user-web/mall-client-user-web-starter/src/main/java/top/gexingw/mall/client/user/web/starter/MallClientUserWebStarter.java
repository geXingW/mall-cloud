package top.gexingw.mall.client.user.web.starter;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/5 11:01
 */
@SpringBootApplication(scanBasePackages = {"top.gexingw.mall", "com.gexingw.mall"})
@EnableDubbo(scanBasePackages = {"top.gexingw.mall"})
public class MallClientUserWebStarter {

    public static void main(String[] args) {
        SpringApplication.run(MallClientUserWebStarter.class, args);
    }

}
