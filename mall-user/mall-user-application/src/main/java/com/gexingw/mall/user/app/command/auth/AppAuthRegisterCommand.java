package com.gexingw.mall.user.app.command.auth;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/13 15:02
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class AppAuthRegisterCommand implements Serializable {

    private String phone;

    private String password;

    public AppAuthRegisterCommand(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

}
