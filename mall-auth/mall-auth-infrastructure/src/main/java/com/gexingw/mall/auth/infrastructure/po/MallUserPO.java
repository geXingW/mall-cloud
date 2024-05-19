package com.gexingw.mall.auth.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.auth.infrastructure.support.AuthUser;
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
@TableName("mall_user")
public class MallUserPO extends BasePO implements AuthUser {

    private String username;

    private String phone;

    private String password;

    private LocalDateTime lastLoginTime;

}
