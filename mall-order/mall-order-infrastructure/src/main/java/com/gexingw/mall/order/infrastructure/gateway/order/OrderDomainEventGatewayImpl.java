package com.gexingw.mall.order.infrastructure.gateway.order;

import com.gexingw.mall.domain.event.order.OrderBaseEvent;
import com.gexingw.mall.domain.gateway.order.OrderDomainEventGateway;
import com.gexingw.mall.order.infrastructure.dataobject.OrderDomainEventDO;
import com.gexingw.mall.order.infrastructure.gateway.order.db.OrderDomainEventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 17:51
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderDomainEventGatewayImpl implements OrderDomainEventGateway {

    private final OrderDomainEventMapper orderDomainEventMapper;

    @Override
    public boolean create(OrderBaseEvent orderEvent) {
        OrderDomainEventDO orderDomainEventDO = new OrderDomainEventDO()
                .setEventId(orderEvent.getIdentity()).setEventType(orderEvent.getType()).setEventPayload(orderEvent.getPayload());
        return orderDomainEventMapper.insert(orderDomainEventDO) > 0;
    }

}
