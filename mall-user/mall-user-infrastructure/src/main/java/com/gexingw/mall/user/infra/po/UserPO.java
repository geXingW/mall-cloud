package com.gexingw.mall.user.infra.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.support.BasePO;
import lombok.Data;

import java.io.Serializable;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/26 13:42
 */
@Data
@TableName("user")
public class UserPO extends BasePO implements Serializable {

    private Long authUserId;

    private String nickname;

    private String phone;

}
