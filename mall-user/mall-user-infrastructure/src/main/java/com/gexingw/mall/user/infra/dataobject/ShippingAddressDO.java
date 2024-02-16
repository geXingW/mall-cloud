package com.gexingw.mall.user.infra.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.dataobject.BaseDO;
import lombok.Data;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/5 13:44
 */
@Data
@TableName("shipping_address")
public class ShippingAddressDO extends BaseDO {

    private Long userId;

    private String province;

    private String city;

    private String district;

    private String address;

    private String phone;

    private String name;

    private Long tagId;

    private Boolean isDefault;

}
