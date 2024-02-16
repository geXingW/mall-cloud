package com.gexingw.mall.common.exception;

import com.gexingw.mall.comm.core.enums.RespCode;
import lombok.Getter;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/8 14:46
 */
@Getter
@SuppressWarnings("unused")
public class BaseException extends RuntimeException {

    protected RespCode respCode;

    public BaseException(String message) {
        super(message);

        respCode = RespCode.SERVER_ERROR;
    }

    public BaseException(RespCode respCode) {
        super(respCode.getMessage());
        this.respCode = respCode;
    }

    public BaseException(RespCode respCode, String message) {
        super(message);
        this.respCode = respCode;
    }

}
