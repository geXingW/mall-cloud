package com.gexingw.mall.common.core.enums;

import com.gexingw.mall.common.core.interfaces.IRespCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.gexingw.mall.common.core.constant.HttpCodeConstant.HTTP_SUCCESS;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/4 21:41
 */
@Getter
@AllArgsConstructor
public enum CommonRespCode implements IRespCode {

    // 成功
    SUCCESS(HTTP_SUCCESS, 2000, "成功！"),
    QUERY_SUCCESS(HTTP_SUCCESS, 2000, "查询成功！"),
    SAVE_SUCCESS(HTTP_SUCCESS, 2000, "已保存！"),
    UPDATE_SUCCESS(HTTP_SUCCESS, 2000, "已更新！"),
    DELETE_SUCCESS(HTTP_SUCCESS, 2000, "已删除！"),

    // 400
    BAD_REQUEST(400, 400000, "异常请求！"),
    // 401,
    UNAUTHORIZED(401, 401000, "未授权！"),
    // 403
    FORBIDDEN(403, 403000, "无权限访问！"),
    // 404
    NOT_FOUND(404, 404000, "资源不存在！"),
    // 422
    PARAMS_INVALID(422, 422000, "请求参数异常！"),

    // 500
    SERVER_ERROR(500, 5000, "系统异常！"),
    BIZ_ERROR(500, 5001, "请求处理异常，请稍后重试！"),

    QUERY_ERROR(500, 50001, "查询失败，请稍后重试！"),
    SAVE_ERROR(500, 50002, "保存失败，请稍后重试！"),
    UPDATE_ERROR(500, 50003, "更新失败，请稍后重试！"),
    DELETE_ERROR(500, 50004, "删除失败，请稍后重试！");

    private final Integer code;

    private final Integer subCode;

    private final String message;

}
