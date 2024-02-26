package com.gexingw.mall.common.core.enums;

import com.gexingw.mall.common.core.interfaces.IRespCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * mall-user-service
 * 认证模块的错误码，业务编码从 <b>500100</b> 开始
 *
 * @author GeXingW
 * @date 2024/2/26 12:03
 */
@Getter
@AllArgsConstructor
public enum AuthRespCode implements IRespCode {

    // 认证异常
    UN_AUTHORIZATION(401, 401101, "认证异常！"),
    INVALID_CLIENT(401, 401102, "授权信息异常！"),
    TOKEN_EXPIRED(401, 401103, "认证已过期！"),

    // 参数异常
    USERNAME_PASSWD_INVALID(422, 422101, "用户名密码错误！"),

    // 服务异常
    SERVER_ERROR(500, 500101, "授权异常！"),

    ;

    /**
     * 一级异常编码
     */
    private final Integer code;

    /**
     * 二级异常编码
     */
    private final Integer subCode;

    /**
     * 异常描述
     */
    private final String message;

}
