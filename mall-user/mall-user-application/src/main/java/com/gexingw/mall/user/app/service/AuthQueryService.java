package com.gexingw.mall.user.app.service;

import com.gexingw.mall.user.app.vo.web.mall.auth.WebMallAuthInfoVO;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/4 18:00
 */
public interface AuthQueryService {

    WebMallAuthInfoVO queryWebUserInfo();

}
