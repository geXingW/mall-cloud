package com.gexingw.mall.auth.adapter.web;

import com.gexingw.mall.auth.application.command.user.AuthUserAddCmd;
import com.gexingw.mall.auth.application.service.AuthUserCommandService;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.spring.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/19 20:25
 */
@RestController
@RequestMapping("/web/auth-user")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthUserAdapter {

    private final CommandBus commandBus;

    private final AuthUserCommandService authUserCommandService;

    @GetMapping
    public R<Object> index() {
        return R.ok();
    }

    @PostMapping
    public R<Long> add(@RequestBody AuthUserAddCmd cmd) {
        return R.ok(commandBus.execute(cmd, Long.class));
    }

    @PutMapping("/{id}")
    public R<Object> update(@PathVariable Long id) {
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Object> delete(@PathVariable Long id) {
        return R.ok();
    }

}
