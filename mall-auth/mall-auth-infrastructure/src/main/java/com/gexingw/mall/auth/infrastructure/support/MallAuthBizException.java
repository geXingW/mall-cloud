package com.gexingw.mall.auth.infrastructure.support;

import com.gexingw.mall.common.core.enums.CommonRespCode;
import com.gexingw.mall.common.exception.BizErrorException;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/27 16:25
 */
public class MallAuthBizException extends BizErrorException {

    public MallAuthBizException(AuthRespCode respCode) {
        super(respCode);
    }

    public MallAuthBizException(CommonRespCode commonRespCode, String message) {
        super(commonRespCode, message);
    }

}
