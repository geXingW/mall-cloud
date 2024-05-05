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

    private String recvUserName;

    private String recvUserPhone;

    private String recvProvince;

    private String recvCity;

    private String recvDistrict;

    private String recvAddress;

    private Long tagId;

    private Boolean isDefault;

}
