package com.gexingw.mall.common.core.util;

import com.gexingw.mall.common.core.enums.CommonRespCode;
import com.gexingw.mall.common.core.interfaces.IRespCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/4 21:36
 */
@SuppressWarnings("unused")
@Getter
public class R<T> implements Serializable {

    /**
     * Http状态码
     */
    private final int code;

    /**
     * 业务响应码
     */
    private final int subCode;

    /**
     * 是否成功
     */
    private final boolean success;

    /**
     * 响应数据
     */
    private final T data;

    /**
     * 响应信息
     */
    private final String message;

    public R(IRespCode respCode) {
        this.code = respCode.getCode();
        this.subCode = respCode.getSubCode();
        this.data = null;
        this.message = respCode.getMessage();
        this.success = CommonRespCode.SUCCESS.getCode().equals(respCode.getCode());
    }

    public R(int code, int subCode, T data, String message) {
        this.code = code;
        this.subCode = subCode;
        this.data = data;
        this.message = message;
        this.success = CommonRespCode.SUCCESS.getCode().equals(code);
    }

    @ResponseStatus(HttpStatus.OK)
    public static <T> R<T> ok() {
        return new R<>(HttpStatus.OK.value(), CommonRespCode.SUCCESS.getSubCode(), null, CommonRespCode.SUCCESS.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    public static <T> R<T> ok(String message) {
        return new R<>(CommonRespCode.SUCCESS.getCode(), CommonRespCode.SUCCESS.getSubCode(), null, message);
    }

    @ResponseStatus(HttpStatus.OK)
    public static <T> R<T> ok(T data) {
        return new R<>(HttpStatus.OK.value(), CommonRespCode.SUCCESS.getSubCode(), data, CommonRespCode.SUCCESS.getMessage());
    }

    public static <T> R<T> fail(IRespCode respCode, String message) {
        return new R<>(respCode.getCode(), respCode.getSubCode(), null, message);
    }

    public static <T> R<T> fail(Integer code, Integer subCode, String message) {
        return new R<>(code, subCode, null, message);
    }

    public static <T> R<T> fail(IRespCode respCode) {
        return new R<>(respCode.getCode(), respCode.getSubCode(), null, respCode.getMessage());
    }

    public static <T> R<T> fail(IRespCode respCode, T data) {
        return new R<>(respCode.getCode(), respCode.getSubCode(), data, respCode.getMessage());
    }

    public static <T> R<T> fail(IRespCode respCode, T data, String message) {
        return new R<>(respCode.getCode(), respCode.getSubCode(), data, message);
    }

}
