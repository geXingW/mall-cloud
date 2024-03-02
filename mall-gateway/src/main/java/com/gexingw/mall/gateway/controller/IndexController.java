package com.gexingw.mall.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/28 13:56
 */
@RestController
@RequestMapping
public class IndexController {

    @GetMapping
    public Object index() {
        return "Welcome to mall cloud gateway";
    }

}
