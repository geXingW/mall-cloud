package com.gexingw.mall.auth.application.command.user;

import com.gexingw.mall.common.core.support.ICommand;
import lombok.Data;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/17 14:20
 */
@Data
public class MallUserCreateCmd implements ICommand {

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String phone;

}
