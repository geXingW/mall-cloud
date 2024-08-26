package com.gexingw.mall.user.app.service;


import com.gexingw.mall.user.app.vo.user.AppUserVO;
import com.gexingw.mall.user.app.vo.user.WebUserVO;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/23 22:04
 */
public interface UserQueryService {

    AppUserVO getAppUserById(Long id);

    WebUserVO getWebUserById(Long id);

}
