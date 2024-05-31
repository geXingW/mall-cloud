package com.gexingw.mall.account.application.command.auth;

import com.gexingw.mall.common.core.support.ICommand;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/21 14:10
 */
@Data
@NoArgsConstructor
public class MallUsernamePasswdLoginCmd implements ICommand {

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String username;

}
