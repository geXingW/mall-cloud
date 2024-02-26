package com.gexingw.mall.common.exception;

import com.gexingw.mall.common.core.enums.CommonRespCode;
import com.gexingw.mall.common.core.interfaces.IRespCode;
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

    protected IRespCode respCode;

    public BaseException(String message) {
        super(message);

        respCode = CommonRespCode.SERVER_ERROR;
    }

    public BaseException(IRespCode respCode) {
        super(respCode.getMessage());
        this.respCode = respCode;
    }

    public BaseException(CommonRespCode commonRespCode, String message) {
        super(message);
        this.respCode = commonRespCode;
    }

}
