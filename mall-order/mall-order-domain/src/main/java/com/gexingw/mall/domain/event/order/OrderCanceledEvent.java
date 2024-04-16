package com.gexingw.mall.domain.event.order;

import com.gexingw.mall.domain.model.order.Order;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/27 14:52
 */
public class OrderCanceledEvent extends OrderBaseEvent {

    public OrderCanceledEvent(Order order) {
        super(order);
    }

}
