package com.gexingw.mall.order.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.dataobject.BaseDO;
import lombok.Data;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/6 17:05
 */
@Data
@TableName("order_shipping_address")
public class OrderShippingAddressDO extends BaseDO {

    private Long orderId;

    private String details;

}
