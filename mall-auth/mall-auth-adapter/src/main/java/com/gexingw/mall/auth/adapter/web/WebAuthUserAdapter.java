package com.gexingw.mall.auth.adapter.web;

import com.gexingw.mall.common.core.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 16:57
 */
@RestController
@RequestMapping("/web/auth-user")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class WebAuthUserAdapter {

    @GetMapping("/{id}")
    public R<Object> info(@PathVariable Long id) {
        return R.ok();
    }

    @PostMapping
    public R<Object> create() {
        return R.ok();
    }

}
