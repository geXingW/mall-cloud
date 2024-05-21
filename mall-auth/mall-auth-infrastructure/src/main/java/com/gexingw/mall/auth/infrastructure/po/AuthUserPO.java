package com.gexingw.mall.auth.infrastructure.po;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 17:51
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Accessors(chain = true)
@Table(name = "auth_user")
public class AuthUserPO {

    @Id
    @GeneratedValue(generator = "snowflake-id-generator")
    @GenericGenerator(name = "snowflake-id-generator", strategy = "com.gexingw.mall.auth.infrastructure.SnowflakeIdGenerator")
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email = "";

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 密码重置时间
     */
    private LocalDateTime passwdResetTime;

}
