package com.gexingw.mall.account.adapter.mall;

import com.gexingw.mall.account.application.command.auth.MallUsernamePasswdLoginCmd;
import com.gexingw.mall.account.application.vo.auth.AuthTokenVO;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.spring.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/16 13:25
 */
@RestController
@RequestMapping("/mall/auth")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class MallAuthController {

    private final CommandBus commandBus;

    @PostMapping("/login")
    public R<AuthTokenVO> login(@RequestBody MallUsernamePasswdLoginCmd loginCmd) {
        return R.ok(commandBus.execute(loginCmd, AuthTokenVO.class));
    }

}
