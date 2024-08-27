package com.gexingw.mall.auth.adapter.dubbo;

import com.gexingw.mall.auth.application.service.AuthCommandService;
import com.gexingw.mall.auth.client.dubbo.AuthDubboService;
import com.gexingw.mall.common.core.util.R;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Lazy;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/27 15:14
 */
@DubboService
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class DubboAuthAdapter implements AuthDubboService {

    private final AuthCommandService authCommandService;

    @Override
    public R<Boolean> logout(String accessToken) {
        authCommandService.logout(accessToken);
        return R.ok(true);
    }

}
