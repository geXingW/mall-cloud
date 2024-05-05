package com.gexingw.mall.order.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.support.BasePO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/4 18:53
 */
@Data
@Accessors(chain = true)
@TableName("order_shipping_address")
public class OrderShippingAddressPO extends BasePO {

    private Long id;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 订单Id
     */
    private Long orderId;

    /**
     * 订单号
     */
    private String orderNo;

    private Long shippingAddressId;

    /**
     * 收货人姓名
     */
    private String recvUserName;

    /**
     * 收货人电话
     */
    private String recvUserPhone;

    /**
     * 收货省份
     */
    private String recvProvince;

    /**
     * 收货城市
     */
    private String recvCity;

    /**
     * 收货区/县
     */
    private String recvDistrict;

    /**
     * 收货详细地址
     */
    private String recvAddress;

}
