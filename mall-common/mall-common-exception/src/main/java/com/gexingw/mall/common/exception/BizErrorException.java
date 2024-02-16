package com.gexingw.mall.common.exception;

import com.gexingw.mall.comm.core.enums.RespCode;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/8 14:45
 */
public class BizErrorException extends BaseException {

    @SuppressWarnings("unused")
    public BizErrorException(String message) {
        super(RespCode.BIZ_ERROR, message);
    }

    public BizErrorException(RespCode respCode) {
        super(respCode);
    }

    public BizErrorException(RespCode respCode, String message) {
        super(respCode, message);
    }

}
