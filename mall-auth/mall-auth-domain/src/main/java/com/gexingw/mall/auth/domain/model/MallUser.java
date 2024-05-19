package com.gexingw.mall.auth.domain.model;

import com.gexingw.mall.common.core.domain.AggregationRoot;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/17 17:10
 */
@Data
@NoArgsConstructor
public class MallUser implements AggregationRoot<Long> {

    private Long id;

    private String username;

    private String password;

    private String phone;

    private LocalDateTime lastLoginTime;

    private LocalDateTime passwdResetTime;

    private Long createUser;

    private LocalDateTime createTime;

    public MallUser(String phone, String password) {
        this(phone, phone, password);
    }

    public MallUser(String username, String phone, String password) {
        this.username = username;
        this.phone = phone;
        this.password = password;
    }


}
