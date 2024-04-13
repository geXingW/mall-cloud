package com.gexingw.mall.order.infra.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.dataobject.BaseDO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author GeXingW
 */
@Data
@TableName("order_item")
@Accessors(chain = true)
public class OrderItemPO extends BaseDO {

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
