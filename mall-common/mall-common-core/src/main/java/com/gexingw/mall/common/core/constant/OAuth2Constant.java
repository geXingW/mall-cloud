package com.gexingw.mall.common.core.constant;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 20:45
 */
public interface OAuth2Constant {

    String STATE_TOKEN_CACHE_NAME = "oauth2:state:%s";

    String AUTHORIZATION_CODE_CACHE_NAME = "oauth2:authorization_code:%s";

    String REFRESH_TOKEN_CACHE_NAME = "oauth2:refresh_token:%s";

    String ACCESS_TOKEN_CACHE_NAME = "oauth2:access_token:%s";

    String ACCESS_TOKEN_AUTH_INFO_CACHE_NAME = "oauth2:access_token:%s:auth_info";

    String TOKEN_SETTINGS = "TOKEN_SETTING";

}
