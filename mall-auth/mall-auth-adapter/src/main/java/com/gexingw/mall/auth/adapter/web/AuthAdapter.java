package com.gexingw.mall.auth.adapter.web;

import com.gexingw.mall.auth.application.service.AuthCommandService;
import com.gexingw.mall.common.core.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/27 13:00
 */
@RestController
@RequestMapping("/web/auth")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthAdapter {

    private final AuthCommandService authCommandService;

    @PostMapping("logout")
    public R<Object> logout(@RequestHeader(value = "authorization", required = false) String accessToken) {
        authCommandService.logout(accessToken);
        return R.ok();
    }

}
