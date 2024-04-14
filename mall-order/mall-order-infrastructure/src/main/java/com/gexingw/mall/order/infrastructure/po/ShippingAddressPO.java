package com.gexingw.mall.order.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.support.BasePO;
import lombok.Data;

/**
 * @author GeXingW
 */
@Data
@TableName("shipping_address")
public class ShippingAddressPO extends BasePO {

    private Long userId;

    private String name;

    private String phone;

    private String province;

    private String city;

    private String district;

    private String address;

    private Long tagId;

    private Boolean isDefault;

}
