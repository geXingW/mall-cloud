package com.gexingw.mall.common.exception;

import com.gexingw.mall.common.core.enums.CommonRespCode;
import com.gexingw.mall.common.core.interfaces.IRespCode;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/8 14:45
 */
public class BizErrorException extends BaseException {

    @SuppressWarnings("unused")
    public BizErrorException(IRespCode respCode) {
        super(respCode);
    }

    public BizErrorException(CommonRespCode commonRespCode, String message) {
        super(commonRespCode, message);
    }

}
