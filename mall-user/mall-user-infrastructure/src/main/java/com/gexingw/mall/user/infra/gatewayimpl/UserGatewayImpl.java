package com.gexingw.mall.user.infra.gatewayimpl;

import com.gexingw.mall.user.domain.user.UserGateway;
import com.gexingw.mall.user.domain.user.model.User;
import com.gexingw.mall.user.infra.dataobject.UserPO;
import com.gexingw.mall.user.infra.gatewayimpl.db.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/23 14:45
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class UserGatewayImpl implements UserGateway {

    private final UserMapper userMapper;

    @Override
    public User getById(Long id) {
        UserPO userPo = userMapper.selectById(id);
        if (userPo == null) {
            return null;
        }

        return new User().setId(userPo.getId()).setUsername(userPo.getName());
    }

}
