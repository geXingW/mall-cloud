package com.gexingw.mall.auth.infrastructure.support;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/17 13:04
 */
public interface AuthUser {

    /**
     * 获取用户id
     *
     * @return 用户id
     */
    Long getId();

    /**
     * 获取用户名
     *
     * @return 用户名
     */
    String getUsername();

    /**
     * 获取密码
     *
     * @return 密码
     */
    String getPassword();

    /**
     * 获取手机号
     *
     * @return 手机号
     */
    String getPhone();

}
