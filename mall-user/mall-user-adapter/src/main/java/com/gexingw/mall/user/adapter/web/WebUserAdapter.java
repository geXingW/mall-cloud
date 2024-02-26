package com.gexingw.mall.user.adapter.web;

import com.gexingw.mall.user.app.service.UserServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gexingw.mall.common.core.util.R;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/19 22:26
 */
@RestController
@RequestMapping("/web/user")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class WebUserAdapter {

    private final UserServiceI userService;

    @GetMapping("/{id}")
    public Object info(@PathVariable Long id) {
        return R.ok(userService.getWebUserById(id));
    }

}
