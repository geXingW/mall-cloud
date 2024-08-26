package com.gexingw.mall.user.infra.dao.user.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.support.BasePO;
import lombok.Data;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/26 13:20
 */
@Data
@TableName("user")
public class UserPO extends BasePO {

    private Long authUserId;

    private String nickname;

    private String phone;

}
