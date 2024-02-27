package com.gexingw.mall.domain.order.model;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.IdUtil;
import com.gexingw.mall.common.core.domain.AggregationRoot;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 15:58
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Order implements AggregationRoot {

    private Long id;

    /**
     * 订单号
     */
    private String number;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 收货地址
     */
    private OrderShippingAddress shippingAddress;

    /**
     * 订单商品
     */
    private List<OrderItem> items = new ArrayList<>();

    /**
     * 创建人
     */
    private OrderCreator creator;

    public Order(List<OrderItem> items, OrderCreator creator, OrderShippingAddress shippingAddress) {
        this.items = items;
        this.creator = creator;
        this.shippingAddress = shippingAddress;

        // 订单总金额
        this.totalAmount = items.stream().map(OrderItem::getTotalAmount).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        this.number = LocalDateTimeUtil.format(LocalDateTime.now(), "yyyyMMddHHmmss");
        this.id = IdUtil.getSnowflakeNextId();
    }

    /**
     * 取消订单
     *
     * @return Order
     */
    public Order cancel() {
        this.status = 2;
        return this;
    }

}
