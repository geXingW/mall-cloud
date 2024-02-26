package com.gexingw.mall.common.exception;

import com.gexingw.mall.common.core.enums.CommonRespCode;
import com.gexingw.mall.common.core.interfaces.IRespCode;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/13 12:12
 */

@SuppressWarnings("unused")
public class BizNotFoundException extends BizErrorException{

    public BizNotFoundException() {
        super(CommonRespCode.NOT_FOUND);
    }

    public BizNotFoundException(String message) {
        super(CommonRespCode.NOT_FOUND, message);
    }

    public BizNotFoundException(IRespCode respCode) {
        super(respCode);
    }

    public BizNotFoundException(CommonRespCode commonRespCode, String message) {
        super(commonRespCode, message);
    }

}
