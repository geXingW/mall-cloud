package top.gexingw.mall.client.user.web.adapter.web;

import com.gexingw.mall.common.core.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import top.gexingw.mall.client.user.web.app.web.auth.command.WebAuthPasswdLoginCommand;
import top.gexingw.mall.client.user.web.app.service.AuthCommandService;
import top.gexingw.mall.client.user.web.app.service.AuthQueryService;
import top.gexingw.mall.client.user.web.app.vo.WebAuthTokenVO;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/5 11:05
 */
@RestController
@RequestMapping("/web/auth")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class WebAuthAdapter {

    private final AuthQueryService authQueryService;
    private final AuthCommandService authCommandService;

    @GetMapping("info")
    public R<Object> info() {
        return R.ok(authQueryService.getInfo());
    }

    /**
     * 密码登录
     *
     * @param passwdLoginCommand 账户信息
     * @return Object
     */
    @PostMapping("passwd-login")
    public R<WebAuthTokenVO> passwdLogin(@RequestBody WebAuthPasswdLoginCommand passwdLoginCommand) {
        return R.ok(authCommandService.login(passwdLoginCommand));
    }

    /**
     * 退出登录
     *
     * @return R
     */
    @PostMapping("logout")
    public R<Object> logout() {
        return R.ok();
    }

}
