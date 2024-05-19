package com.gexingw.mall.auth.adapter.web;

import com.gexingw.mall.auth.application.command.user.MallUserCreateCmd;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.spring.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 16:57
 */
@RestController
@RequestMapping("/web/mall_user")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class MallUserAdapter {

    private final CommandBus commandBus;

    @GetMapping("/{id}")
    public R<Object> info(@PathVariable Long id) {
        return R.ok();
    }

    @PostMapping
    public R<Long> create(@RequestBody @Validated MallUserCreateCmd createCmd) {
        return R.ok(commandBus.execute(createCmd, Long.class));
    }

}
