package com.gexingw.mall.user.app.service;

import com.gexingw.mall.user.app.command.auth.AppAuthLoginCommand;
import com.gexingw.mall.user.app.vo.mall.AppAuthLoginVO;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/4 17:59
 */
public interface AuthCommandService {

    AppAuthLoginVO login(AppAuthLoginCommand loginCmd);

    void logout(AppAuthLoginCommand loginCmd);

}
