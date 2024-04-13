package com.gexingw.mall.product.adapter.web;

import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.spring.command.CommandBus;
import com.gexingw.mall.product.application.commd.product.ProductAddCommand;
import com.gexingw.mall.product.application.service.ProductService;
import com.gexingw.mall.product.application.vo.product.WebProductInfoVO;
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
public class WebProductAdapter {

    private final CommandBus commandBus;
    private final ProductService productService;

    @GetMapping
    public R<Object> index() {
        return R.ok("Product index");
    }

    @GetMapping("/{id}")
    public R<WebProductInfoVO> info(@PathVariable Long id) {
        return R.ok(productService.webInfo(id));
    }

    @PostMapping
    public R<Object> save(@RequestBody ProductAddCommand addCommand) {
        return R.ok(commandBus.execute(addCommand, Long.class));
    }

}
