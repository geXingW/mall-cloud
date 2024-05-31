package com.gexingw.mall.account.adapter.platform;

import com.gexingw.mall.common.core.util.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/16 13:29
 */
@RestController
@RequestMapping("/platform/auth")
public class PlatformAuthController {

    @PostMapping("login")
    public R<Object> login() {
        return R.ok();
    }

}
