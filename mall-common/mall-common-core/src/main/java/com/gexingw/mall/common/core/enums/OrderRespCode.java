package com.gexingw.mall.common.core.enums;

import com.gexingw.mall.common.core.interfaces.IRespCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 12:01
 */
@Getter
@AllArgsConstructor
public enum OrderRespCode implements IRespCode {

    SUBMIT_ERROR(500, 500201, "订单提交失败，请稍后重试！"),

    CANCEL_ERROR(500, 500201, "取消失败，请稍后重试！"),

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
