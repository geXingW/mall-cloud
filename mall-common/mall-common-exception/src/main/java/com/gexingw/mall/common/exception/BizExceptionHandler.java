package com.gexingw.mall.common.exception;

import com.gexingw.mall.common.core.interfaces.IRespCode;
import com.gexingw.mall.common.core.util.R;
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
        IRespCode respCode = bizNotFoundException.getRespCode();
        return R.fail(respCode, bizNotFoundException.getMessage());
    }

}
