package com.gexingw.mall.account.adapter.merchant;

import com.gexingw.mall.common.core.util.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/16 13:31
 */
@RestController("/merchant/auth")
public class MerchantAuthController {

    @PostMapping("login")
    public R<Object> login() {
        return R.ok();
    }

}
