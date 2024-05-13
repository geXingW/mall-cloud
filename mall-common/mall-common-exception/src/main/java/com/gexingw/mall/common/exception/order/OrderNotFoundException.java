package com.gexingw.mall.common.exception.order;

import com.gexingw.mall.common.core.enums.CommonRespCode;
import com.gexingw.mall.common.core.interfaces.IRespCode;
import com.gexingw.mall.common.exception.BaseException;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/13 18:16
 */
public class OrderNotFoundException extends BaseException {

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(IRespCode respCode) {
        super(respCode);
    }

    public OrderNotFoundException(CommonRespCode commonRespCode, String message) {
        super(commonRespCode, message);
    }

}
