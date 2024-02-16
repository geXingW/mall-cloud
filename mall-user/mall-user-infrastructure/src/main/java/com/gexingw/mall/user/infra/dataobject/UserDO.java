package com.gexingw.mall.user.infra.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.dataobject.BaseDO;
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
public class UserDO extends BaseDO implements Serializable {

    private String name;

}
