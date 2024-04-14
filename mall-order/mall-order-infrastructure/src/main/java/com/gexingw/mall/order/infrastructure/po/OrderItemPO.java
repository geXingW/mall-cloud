package com.gexingw.mall.order.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.support.BasePO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author GeXingW
 */
@Data
@TableName("order_item")
@Accessors(chain = true)
public class OrderItemPO extends BasePO {

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
