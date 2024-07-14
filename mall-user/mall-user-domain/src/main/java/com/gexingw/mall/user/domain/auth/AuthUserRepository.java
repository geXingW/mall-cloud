package com.gexingw.mall.user.domain.auth;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/12 13:27
 */
public interface AuthUserRepository {

    Long register(AuthUser authUser);

    AuthToken login(String phone, String password);

    AuthUser findByPhone(String phone);

}
