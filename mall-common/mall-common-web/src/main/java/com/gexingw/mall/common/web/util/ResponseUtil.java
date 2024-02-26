package com.gexingw.mall.common.web.util;

import com.alibaba.fastjson2.support.spring.http.converter.FastJsonHttpMessageConverter;
import com.gexingw.mall.common.core.interfaces.IRespCode;
import com.gexingw.mall.common.core.util.R;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;

import javax.servlet.http.HttpServletResponse;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 10:52
 */
public class ResponseUtil {

    @SneakyThrows
    public static void jsonResponse(HttpServletResponse response, IRespCode respCode) {
        ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response);
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.write(R.fail(respCode), MediaType.APPLICATION_JSON, httpResponse);
    }

    @SneakyThrows
    public static void jsonResponse(ServletServerHttpResponse httpResponse, IRespCode respCode) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.write(R.fail(respCode), MediaType.APPLICATION_JSON, httpResponse);
    }

    @SneakyThrows
    public static void jsonResponse(ServletServerHttpResponse httpResponse, Integer code, Integer subCode, String respMessage) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.write(R.fail(code, subCode, respMessage), MediaType.APPLICATION_JSON, httpResponse);
    }

}
