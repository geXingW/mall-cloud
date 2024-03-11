package com.gexingw.mall.product.adapter.web;

import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.spring.command.CommandBus;
import com.gexingw.mall.product.application.commd.product.ProductAddCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/24 10:31
 */
@RestController
@RequestMapping("/web/product")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProductAdapter {

    private final CommandBus commandBus;

    @GetMapping
    public R<Object> index() {
        return R.ok("Product index");
    }

    @GetMapping("/{id}")
    public R<Object> info(@PathVariable String id) {
        return R.ok("Product-" + id);
    }

    @PostMapping
    public R<Object> save(@RequestBody ProductAddCommand addCommand) {
        return R.ok(commandBus.execute(addCommand, Long.class));
    }

}
