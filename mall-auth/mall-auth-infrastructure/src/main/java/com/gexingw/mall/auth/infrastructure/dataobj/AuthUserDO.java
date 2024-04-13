package com.gexingw.mall.auth.infrastructure.dataobj;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.support.BasePO;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 20:09
 */
@Data
@TableName("auth_user")
public class AuthUserDO extends BasePO {

    private String username;

    private String phone;

    private String password;

    private LocalDateTime lastLoginTime;

}
