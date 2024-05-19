package com.gexingw.mall.auth.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.auth.infrastructure.support.AuthUser;
import com.gexingw.mall.common.db.support.BasePO;
import lombok.Data;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/17 13:05
 */
@Data
@TableName("group_user")
public class GroupUserPO extends BasePO implements AuthUser {

    private String username;

    private String password;

    private String phone;

    private Integer status;

}
