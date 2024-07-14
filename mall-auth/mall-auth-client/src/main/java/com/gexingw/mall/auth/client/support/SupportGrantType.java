package com.gexingw.mall.auth.client.support;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/31 14:08
 */
@Getter
@AllArgsConstructor
public enum SupportGrantType {

    /**
     * 密码模式
     */
    PASSWORD("password"),

    /**
     * 授权码模式
     */
    AUTHORIZATION_CODE("authorization_code"),

    /**
     * 刷新令牌
     */
    REFRESH_TOKEN("refresh_token"),

    /**
     * 客户端模式
     */
    CLIENT_CREDENTIALS("client_credentials"),

    /**
     * 短信验证码
     */
    SMS_VERIFY_CODE("sms_verify_code"),

    /**
     * 手机号一键登录
     */
    MOBILE_TOKEN("mobile_token"),

    ;

    private final String grantType;

}
