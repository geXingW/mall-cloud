package com.gexingw.mall.auth.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import top.gexingw.ddd.core.AggregateRoot;

import java.time.LocalDateTime;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 17:02
 */
@Data
@NoArgsConstructor
public class AuthUser implements AggregateRoot<Long> {

    private Long id;

    private String name;

    private String username;

    private String phone;

    private String password;

    private Integer userType;

    private LocalDateTime lastLoginTime;

    private LocalDateTime passwdResetTime;

    public AuthUser(String phone, String encodePassword) {
        this(phone, phone, phone, encodePassword, 0);
    }

    public AuthUser(String phone, String encodePassword, Integer userType) {
        this(phone, phone, phone, encodePassword, userType);
    }

    public AuthUser(String name, String username, String phone, String encodePassword, Integer userType) {
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.password = encodePassword;
        this.userType = userType;
    }

}
