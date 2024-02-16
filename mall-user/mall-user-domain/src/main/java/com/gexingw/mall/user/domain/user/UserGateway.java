package com.gexingw.mall.user.domain.user;

import com.gexingw.mall.user.domain.user.model.User;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/23 14:50
 */
public interface UserGateway {

    User getById(Long id);

}
