package com.gexingw.mall.user.adapter.web;

import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.user.app.command.auth.WebMallAuthLoginCommand;
import com.gexingw.mall.user.app.service.AuthCommandService;
import com.gexingw.mall.user.app.service.AuthQueryService;
import com.gexingw.mall.user.app.vo.web.mall.auth.WebMallAuthLoginVO;
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
 * @date 2024/8/26 13:25
 */
@RestController
@RequestMapping("/web/mall/auth")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class WebMallAuthAdapter {

    private final AuthQueryService authQueryService;
    private final AuthCommandService authCommandService;

    @PostMapping("login")
    public R<WebMallAuthLoginVO> login(@RequestBody WebMallAuthLoginCommand loginCommand) {
        return R.ok(authCommandService.login(loginCommand));
    }


}
