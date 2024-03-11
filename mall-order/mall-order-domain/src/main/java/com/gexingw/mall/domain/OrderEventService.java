package com.gexingw.mall.domain;

import com.gexingw.mall.common.spring.event.IDomainEventService;
import com.gexingw.mall.common.spring.event.IEvent;
import com.gexingw.mall.domain.event.order.OrderBaseEvent;
import com.gexingw.mall.domain.gateway.OrderDomainEventGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 17:47
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderEventService implements IDomainEventService<OrderBaseEvent> {

    private final OrderDomainEventGateway orderDomainEventGateway;

    @Override
    public boolean store(OrderBaseEvent event) {
        return orderDomainEventGateway.create(event);
    }

    @Override
    public void broadcast(IEvent event) {

    }
}
