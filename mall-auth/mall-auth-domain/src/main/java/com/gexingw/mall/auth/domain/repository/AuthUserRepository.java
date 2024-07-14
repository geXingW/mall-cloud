package com.gexingw.mall.auth.domain.repository;

import com.gexingw.mall.auth.domain.model.AuthUser;
import com.gexingw.mall.common.core.support.Repository;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 17:58
 */
public interface AuthUserRepository extends Repository<AuthUser, Long> {

    AuthUser findByUsername(String username);

}
