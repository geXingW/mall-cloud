package com.gexingw.mall.domain.event.order;

import com.gexingw.mall.domain.model.order.Order;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 15:28
 */
public class OrderCreatedEvent extends OrderBaseEvent {

    public OrderCreatedEvent(Order order) {
        super(order);
    }

}
