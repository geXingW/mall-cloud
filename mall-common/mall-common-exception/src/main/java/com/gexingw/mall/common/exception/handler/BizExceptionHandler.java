package com.gexingw.mall.common.exception.handler;

import com.gexingw.mall.comm.core.enums.RespCode;
import com.gexingw.mall.comm.core.util.R;
import com.gexingw.mall.common.exception.BizNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/13 12:08
 */
@Slf4j
@RestControllerAdvice
@ConditionalOnClass(RestControllerAdvice.class)
public class BizExceptionHandler {

    @ExceptionHandler({BizNotFoundException.class})
    public R<Object> exceptionHandler(BizNotFoundException bizNotFoundException) {
        RespCode respCode = bizNotFoundException.getRespCode();
        return R.fail(respCode, bizNotFoundException.getMessage());
    }

}
