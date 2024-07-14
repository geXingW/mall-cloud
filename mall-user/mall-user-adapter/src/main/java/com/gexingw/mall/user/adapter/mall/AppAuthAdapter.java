package com.gexingw.mall.user.adapter.mall;

import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.user.app.command.auth.AppAuthLoginCommand;
import com.gexingw.mall.user.app.service.AuthCommandService;
import com.gexingw.mall.user.app.service.AuthQueryService;
import com.gexingw.mall.user.app.vo.mall.AppAuthLoginVO;
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
 * @date 2024/7/4 16:05
 */
@RestController
@RequestMapping("/mall/app/auth")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AppAuthAdapter {

    private final AuthCommandService authCommandService;
    private final AuthQueryService authQueryService;

    @PostMapping("login")
    public R<AppAuthLoginVO> login(@RequestBody AppAuthLoginCommand loginCmd) {
        return R.ok(authCommandService.login(loginCmd));
    }

    @PostMapping("logout")
    public R<Object> logout(@RequestBody AppAuthLoginCommand loginCmd) {
        authCommandService.logout(loginCmd);
        return R.ok();
    }

}
