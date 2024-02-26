package com.gexingw.mall.product.adapter.web;

import com.gexingw.mall.common.core.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/24 10:31
 */
@RestController
@RequestMapping("product")
public class ProductAdapter {

    @GetMapping
    public R<Object> index() {
        return R.ok("Product index");
    }

    @GetMapping("/{id}")
    public R<Object> info(@PathVariable String id) {
        return R.ok("Product-" + id);
    }

}
