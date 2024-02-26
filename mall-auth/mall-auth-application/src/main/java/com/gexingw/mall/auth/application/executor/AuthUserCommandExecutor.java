package com.gexingw.mall.auth.application.executor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.auth.infrastructure.dataobj.AuthUserDO;
import com.gexingw.mall.auth.infrastructure.gateway.authuser.db.AuthUserMapper;
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

    public AuthUserDO getByUsername(String username){
        LambdaQueryWrapper<AuthUserDO> qryWrapper = new LambdaQueryWrapper<AuthUserDO>().eq(AuthUserDO::getUsername, username);

        return authUserMapper.selectOne(qryWrapper);
    }

}
