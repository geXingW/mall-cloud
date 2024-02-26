package com.gexingw.mall.common.web.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 19:34
 */
public class HttpParamUtil {

    public static Map<String, Object> getRequestParams(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> parameters = new HashMap<>(parameterMap.size());
        parameterMap.forEach((key, values) -> {
            for (String value : values) {
                parameters.put(key, value);
            }
        });

        return parameters;
    }

    public static Object getRequestParam(HttpServletRequest request, String paramName) {
        Map<String, Object> reqParams = getRequestParams(request);

        return reqParams.get(paramName);
    }


}
