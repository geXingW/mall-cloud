package top.gexingw.mall.service.user.starter;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/10/18 13:53
 */
@SpringBootApplication(scanBasePackages = {"com.gexingw.mall", "top.gexingw.mall", "com.gexingw.mall.common"})
@EnableDubbo(scanBasePackages = {"top.gexingw.mall", "com.gexingw.mall"})
@MapperScan(basePackages = {"top.gexingw.mall.service.user.dao.mall.user"})
public class MallServiceUserStarter {

    public static void main(String[] args) {
        SpringApplication.run(MallServiceUserStarter.class, args);
    }

}
