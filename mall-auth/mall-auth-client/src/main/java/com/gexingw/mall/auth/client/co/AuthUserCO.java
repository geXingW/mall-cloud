package com.gexingw.mall.auth.client.co;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 17:01
 */
@Getter
public class AuthUserCO implements Serializable {

    private Long id;

    private String name;

    private String phone;

    private String email;

    private LocalDateTime lastLoginTime;

}
