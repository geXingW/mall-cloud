package com.gexingw.mall.domain.event.order;

import com.gexingw.mall.common.spring.event.IEvent;
import com.gexingw.mall.domain.model.order.Order;
import top.gexingw.ddd.core.AggregateRoot;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 15:38
 */
public class OrderBaseEvent implements IEvent {

    private final Order order;

    public OrderBaseEvent(Order order) {
        this.order = order;
    }

    @Override
    public Long getIdentity() {
        return order.getId();
    }

    @Override
    public String getType() {
        return "order";
    }

    @Override
    public AggregateRoot<Long> getPayload() {
        return this.order;
    }

}
