package com.gexingw.mall.auth.application.executor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.auth.infrastructure.gateway.authuser.db.AuthUserMapper;
import com.gexingw.mall.auth.infrastructure.po.AuthUserPO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 20:01
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthUserCommandExecutor {

    private final AuthUserMapper authUserMapper;

    public AuthUserPO getByUsername(String username) {
        LambdaQueryWrapper<AuthUserPO> qryWrapper = new LambdaQueryWrapper<AuthUserPO>().eq(AuthUserPO::getUsername, username);

        return authUserMapper.selectOne(qryWrapper);
    }

}
