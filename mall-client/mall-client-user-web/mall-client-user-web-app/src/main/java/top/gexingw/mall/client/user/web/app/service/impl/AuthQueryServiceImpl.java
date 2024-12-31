package top.gexingw.mall.client.user.web.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import top.gexingw.mall.client.user.web.app.service.AuthQueryService;
import top.gexingw.mall.client.user.web.infra.rpc.user.mall.user.MallUserDTO;
import top.gexingw.mall.client.user.web.infra.rpc.user.mall.user.UserMallUserClient;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/5 11:11
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthQueryServiceImpl implements AuthQueryService {

    private final UserMallUserClient userMallUserClient;
    @Override
    public Object getInfo() {
        return userMallUserClient.findByPhone("123456");
    }

}
