package com.gexingw.mall.order.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.support.BasePO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

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
     * 订单编号
     */
    private String orderNo;

    /**
     * 商品Id
     */
    private Long productId;

    /**
     * 商品编号
     */
    private String productNo;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 售价
     */
    private BigDecimal productSalePrice;

    /**
     * 市场价
     */
    private BigDecimal productMarketPrice;

    /**
     * 图片
     */
    private String productPic;

    /**
     * 数量
     */
    private Integer quantity;

}
