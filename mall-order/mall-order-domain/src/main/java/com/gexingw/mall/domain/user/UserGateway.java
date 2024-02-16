package com.gexingw.mall.domain.user;

import com.gexingw.mall.domain.user.model.User;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/15 13:15
 */
public interface UserGateway {

    User getById(long id);

}
