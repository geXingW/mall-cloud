package com.gexingw.mall.user.app.executor.user;

import com.gexingw.mall.user.app.vo.user.WebUserVO;
import com.gexingw.mall.user.domain.user.model.User;
import com.gexingw.mall.user.domain.user.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/4 22:29
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class WebUserQueryExecutor {

    private final UserGateway userGateway;


    public WebUserVO getById(Long id) {
        User user = userGateway.getById(id);

        return new WebUserVO(user.getId(), user.getUsername());
    }

}
