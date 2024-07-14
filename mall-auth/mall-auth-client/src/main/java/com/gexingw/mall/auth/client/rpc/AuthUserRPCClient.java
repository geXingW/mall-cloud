package com.gexingw.mall.auth.client.rpc;

import com.gexingw.mall.auth.client.command.user.UserRegisterCommand;
import com.gexingw.mall.common.core.util.R;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 17:00
 */
public interface AuthUserRPCClient {

    R<Long> register(UserRegisterCommand registerCommand);

}
