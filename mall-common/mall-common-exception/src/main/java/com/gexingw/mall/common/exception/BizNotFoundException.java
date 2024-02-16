package com.gexingw.mall.common.exception;

import com.gexingw.mall.comm.core.enums.RespCode;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/13 12:12
 */

@SuppressWarnings("unused")
public class BizNotFoundException extends BizErrorException{

    public BizNotFoundException() {
        super(RespCode.NOT_FOUND);
    }

    public BizNotFoundException(String message) {
        super(RespCode.NOT_FOUND, message);
    }

    public BizNotFoundException(RespCode respCode) {
        super(respCode);
    }

    public BizNotFoundException(RespCode respCode, String message) {
        super(respCode, message);
    }

}
