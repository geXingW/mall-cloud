package com.gexingw.mall.user.app.command.auth;

import com.gexingw.mall.common.core.support.ICommand;
import lombok.Data;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/4 18:01
 */
@Data
public class AppAuthLoginCommand implements ICommand {

    private String phone;

    private String password;

}
