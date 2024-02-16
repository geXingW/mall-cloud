package com.gexingw.mall.user.app.executor.user;

import com.gexingw.mall.user.app.vo.user.AppUserVO;
import com.gexingw.mall.user.domain.user.model.User;
import com.gexingw.mall.user.domain.user.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 11:50
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AppUserQueryExecutor {

    private final UserGateway userGateway;

    public AppUserVO getAppUserById(Long id) {
        User user = userGateway.getById(id);
        if (user == null) {
            return null;
        }

        return new AppUserVO().setId(user.getId()).setName(user.getUsername());
    }

}
