package com.gexingw.mall.common.exception;

import com.gexingw.mall.comm.core.enums.RespCode;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/8 14:53
 */
@SuppressWarnings("unused")
public class ParamInvalidException extends BizErrorException {

    public ParamInvalidException(String message) {
        super(RespCode.PARAMS_INVALID, message);
    }

    public ParamInvalidException(RespCode respCode) {
        super(respCode);
    }

    public ParamInvalidException(RespCode respCode, String message) {
        super(respCode, message);
    }

}
