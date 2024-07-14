package com.gexingw.mall.auth.client.command.user;

import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/13 15:41
 */
@Getter
@Accessors(chain = true)
public class UserRegisterCommand implements Serializable {

    /**
     * 用户名
     */
    public String username;

    /**
     * 密码
     */
    public String password;

    /**
     * 手机号
     */
    public String phone;

    /**
     * 邮箱
     */
    public String email;

    public UserRegisterCommand(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = "";
    }

}
