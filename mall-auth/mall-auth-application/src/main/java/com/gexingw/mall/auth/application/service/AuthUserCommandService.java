package com.gexingw.mall.auth.application.service;

import com.gexingw.mall.auth.client.command.user.UserRegisterCommand;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/13 23:04
 */
public interface AuthUserCommandService {

    Long register(UserRegisterCommand registerCommand);

}
