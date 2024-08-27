package com.gexingw.mall.auth.client.dubbo;

import com.gexingw.mall.auth.client.command.user.UserRegisterCommand;
import com.gexingw.mall.common.core.util.R;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/27 15:10
 */
public interface AuthUserDubboService {

    R<Long> register(UserRegisterCommand registerCommand);

}
