package com.gexingw.mall.auth.adapter.dubbo;

import com.gexingw.mall.auth.application.service.AuthUserCommandService;
import com.gexingw.mall.auth.client.command.user.UserRegisterCommand;
import com.gexingw.mall.auth.client.dubbo.AuthUserDubboService;
import com.gexingw.mall.common.core.util.R;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Lazy;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/19 20:25
 */
@DubboService
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class DubboAuthUserAdapter implements AuthUserDubboService {

    private final AuthUserCommandService authUserCommandService;

    @Override
    public R<Long> register(UserRegisterCommand registerCommand) {
        return R.ok(authUserCommandService.register(registerCommand));
    }

}
