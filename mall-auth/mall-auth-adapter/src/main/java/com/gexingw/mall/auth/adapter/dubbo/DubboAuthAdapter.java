package com.gexingw.mall.auth.adapter.dubbo;

import com.gexingw.mall.auth.application.service.AuthCommandService;
import com.gexingw.mall.auth.application.service.AuthQueryService;
import com.gexingw.mall.auth.client.co.AuthInfoCO;
import com.gexingw.mall.auth.client.dubbo.AuthDubboService;
import com.gexingw.mall.auth.infrastructure.support.AuthRespCode;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.security.support.AuthUtil;
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
    private final AuthQueryService authQueryService;

    @Override
    public R<Boolean> logout(String accessToken) {
        authCommandService.logout(accessToken);
        return R.ok(true);
    }

    @Override
    public R<AuthInfoCO> info() {
        if (!AuthUtil.getAuthInfo().isPresent()) {
            return R.fail(AuthRespCode.UN_AUTHORIZED, "请先登录！");
        }

        return R.ok(new AuthInfoCO().setId(AuthUtil.getAuthUserId()).setName(AuthUtil.getAuthUsername()));
    }

}
