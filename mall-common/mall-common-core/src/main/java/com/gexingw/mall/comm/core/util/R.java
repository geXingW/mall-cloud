package com.gexingw.mall.comm.core.util;

import com.gexingw.mall.comm.core.enums.RespCode;
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

    public R(RespCode respCode) {
        this.code = respCode.getCode();
        this.subCode = respCode.getSubCode();
        this.data = null;
        this.message = respCode.getMessage();
        this.success = RespCode.SUCCESS.getCode().equals(respCode.getCode());
    }

    public R(int code, int subCode, T data, String message) {
        this.code = code;
        this.subCode = subCode;
        this.data = data;
        this.message = message;
        this.success = RespCode.SUCCESS.getCode().equals(code);
    }

    @ResponseStatus(HttpStatus.OK)
    public static <T> R<T> ok(T data) {
        return new R<>(HttpStatus.OK.value(), RespCode.SUCCESS.getSubCode(), data, RespCode.SUCCESS.getMessage());
    }

    public static <T> R<T> fail(RespCode respCode, String message) {
        return new R<>(respCode.getCode(), respCode.getSubCode(), null, message);
    }

    public static <T> R<T> fail(RespCode respCode) {
        return new R<>(respCode.getCode(), respCode.getSubCode(), null, respCode.getMessage());
    }

    public static <T> R<T> fail(RespCode respCode, T data) {
        return new R<>(respCode.getCode(), respCode.getSubCode(), data, respCode.getMessage());
    }

    public static <T> R<T> fail(RespCode respCode, T data, String message) {
        return new R<>(respCode.getCode(), respCode.getSubCode(), data, message);
    }

}
