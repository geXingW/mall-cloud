package top.gexingw.mall.client.user.web.infra.rpc.user;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import top.gexingw.mall.service.user.client.dubbo.DubboMallUserClient;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/5 11:32
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class UserAuthClient {

    @DubboReference
    private DubboMallUserClient mallUserClient;

}
