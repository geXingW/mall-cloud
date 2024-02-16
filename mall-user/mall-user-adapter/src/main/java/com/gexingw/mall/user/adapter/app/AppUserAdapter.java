package com.gexingw.mall.user.adapter.app;

import com.gexingw.mall.user.app.service.UserServiceI;
import com.gexingw.mall.user.app.vo.user.AppUserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/19 22:30
 */
@RestController
@RequestMapping("/app/user")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AppUserAdapter {

    private final UserServiceI userServiceI;

    @GetMapping("/{id}")
    public AppUserVO index(@PathVariable Long id) {
        return userServiceI.getAppUserById(id);
    }

}
