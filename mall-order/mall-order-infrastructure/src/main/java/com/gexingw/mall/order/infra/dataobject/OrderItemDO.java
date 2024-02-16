package com.gexingw.mall.order.infra.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.dataobject.BaseDO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:59
 */
@Data
@TableName("order_item")
@Accessors(chain = true)
public class OrderItemDO extends BaseDO {

    /**
     * 订单Id
     */
    private Long orderId;

    /**
     * 商品Id
     */
    private Long productId;

    /**
     * 数量
     */
    private Integer quantity;

}
