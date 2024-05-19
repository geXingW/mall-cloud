package com.gexingw.mall.auth.application.command.user;

import com.gexingw.mall.common.core.support.ICommand;
import lombok.Data;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 22:19
 */
@Data
public class AuthUserAddCmd implements ICommand {

    private String name;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Integer userType;

}
