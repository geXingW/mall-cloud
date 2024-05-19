package com.gexingw.mall.auth.infrastructure.gateway.authuser;

import com.gexingw.mall.auth.domain.gateway.AuthUserGateway;
import com.gexingw.mall.auth.domain.model.AuthUser;
import com.gexingw.mall.auth.infrastructure.convert.AuthUserConvert;
import com.gexingw.mall.auth.infrastructure.gateway.authuser.db.AuthUserMapper;
import com.gexingw.mall.auth.infrastructure.po.AuthUserPO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 17:57
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthUserGatewayImpl implements AuthUserGateway {

    private final AuthUserMapper authUserMapper;
    private final AuthUserConvert authUserConvert;

    @Override
    public AuthUser selectById(Long id) {
        AuthUserPO authUserPO = authUserMapper.selectById(id);

        return authUserConvert.toDomain(authUserPO);
    }

    @Override
    public Boolean save(AuthUser authUser) {
        AuthUserPO authUserPO = authUserConvert.toPO(authUser);
        if (authUserMapper.insert(authUserPO) == 0) {
            return false;
        }
        authUser.setId(authUserPO.getId());

        return true;
    }

}
