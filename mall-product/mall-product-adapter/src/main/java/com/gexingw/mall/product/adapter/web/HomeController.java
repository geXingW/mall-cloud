package com.gexingw.mall.product.adapter.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/24 11:16
 */
@RestController
@RequestMapping
public class HomeController {

    @GetMapping
    public Object index() {
        return "Product home controller.";
    }

}
