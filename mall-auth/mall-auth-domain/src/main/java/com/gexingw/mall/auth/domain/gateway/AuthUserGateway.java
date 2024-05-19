package com.gexingw.mall.auth.domain.gateway;

import com.gexingw.mall.auth.domain.model.AuthUser;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 17:56
 */
public interface AuthUserGateway {


    AuthUser selectById(Long id);

    Boolean save(AuthUser authUser);

}
