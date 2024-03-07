package com.gexingw.mall.common.core.enums;

import com.gexingw.mall.common.core.interfaces.IRespCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 9:43
 */
@Getter
@AllArgsConstructor
public enum ProductRespCode implements IRespCode {

    NOT_FOUNT(404, 404301, "商品信息不存在！"),

    ;

    private final Integer code;

    private final Integer subCode;

    private final String message;

}
