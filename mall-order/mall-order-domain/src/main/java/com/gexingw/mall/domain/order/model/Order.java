package com.gexingw.mall.domain.order.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 15:58
 */
@Data
@Accessors(chain = true)
public class Order implements Serializable {

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
     * 收货地址
     */
    private OrderShippingAddress orderShippingAddress;

    /**
     * 订单商品
     */
    private List<OrderItem> orderItems = new ArrayList<>();

    /**
     * 创建人
     */
    private OrderCreator orderCreator;

}
