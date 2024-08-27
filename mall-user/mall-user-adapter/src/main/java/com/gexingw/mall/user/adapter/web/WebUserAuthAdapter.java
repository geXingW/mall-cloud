package com.gexingw.mall.user.adapter.web;

import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.user.app.command.auth.WebMallAuthLoginCommand;
import com.gexingw.mall.user.app.service.AuthCommandService;
import com.gexingw.mall.user.app.service.AuthQueryService;
import com.gexingw.mall.user.app.vo.web.mall.auth.WebMallAuthInfoVO;
import com.gexingw.mall.user.app.vo.web.mall.auth.WebMallAuthTokenVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/26 13:25
 */
@Slf4j
@RestController
@RequestMapping("/web/user/auth")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class WebUserAuthAdapter {

    private final AuthQueryService authQueryService;
    private final AuthCommandService authCommandService;

    @GetMapping("/info")
    public R<WebMallAuthInfoVO> info() {
        return R.ok(authQueryService.queryWebUserInfo());
    }

    @PostMapping("login")
    public R<WebMallAuthTokenVO> login(@RequestBody WebMallAuthLoginCommand loginCommand) {
        return R.ok(authCommandService.login(loginCommand));
    }

    @PostMapping("logout")
    public R<Object> logout() {
        return R.ok();
    }

}
