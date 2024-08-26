package com.gexingw.mall.user.app.command.auth;

import lombok.Data;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/26 14:14
 */
@Data
public class WebMallAuthLoginCommand implements Serializable {

    private String phone;

    private String password;

}
