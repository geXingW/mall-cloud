package com.gexingw.mall.common.exception;

import com.gexingw.mall.common.core.enums.CommonRespCode;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/8 14:53
 */
@SuppressWarnings("unused")
public class ParamInvalidException extends BizErrorException {

    public ParamInvalidException(String message) {
        super(CommonRespCode.PARAMS_INVALID, message);
    }

    public ParamInvalidException(CommonRespCode commonRespCode) {
        super(commonRespCode);
    }

    public ParamInvalidException(CommonRespCode commonRespCode, String message) {
        super(commonRespCode, message);
    }

}
