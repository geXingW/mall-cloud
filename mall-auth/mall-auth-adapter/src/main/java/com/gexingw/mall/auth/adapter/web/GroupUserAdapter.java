package com.gexingw.mall.auth.adapter.web;

import com.gexingw.mall.auth.application.command.user.GroupUserCreateCmd;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.spring.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 22:03
 */
@RestController
@RequestMapping("/web/group_user")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class GroupUserAdapter {

    private final CommandBus commandBus;

    @GetMapping
    public R<Object> index() {
        return R.ok();
    }

    @PostMapping
    public R<Long> save(@RequestBody GroupUserCreateCmd createCmd) {
        Long authUserId = commandBus.execute(createCmd, Long.class);

        return R.ok(authUserId);
    }

    @PutMapping("/{id}")
    public R<Boolean> update(@PathVariable Long id) {
        return R.ok(true);
    }

    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Long id) {
        return R.ok(true);
    }

}
