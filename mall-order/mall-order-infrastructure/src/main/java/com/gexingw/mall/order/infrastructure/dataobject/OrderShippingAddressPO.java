package com.gexingw.mall.order.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.support.BasePO;
import lombok.Data;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/6 17:05
 */
@Data
@TableName("order_shipping_address")
public class OrderShippingAddressPO extends BasePO {

    private Long orderId;

    private String details;

}
