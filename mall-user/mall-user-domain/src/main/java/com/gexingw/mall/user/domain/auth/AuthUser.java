package com.gexingw.mall.user.domain.auth;

import com.gexingw.mall.common.core.annotation.ValueObject;
import lombok.Getter;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/12 13:19
 */
@Getter
@ValueObject
public class AuthUser implements Serializable {

    private Long id;

    private final String name;

    private final String phone;

    private final String password;

    public AuthUser(String name, String phone, String password) {
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

}
