package com.gexingw.mall.domain.gateway;

import com.gexingw.mall.domain.event.order.OrderBaseEvent;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 17:50
 */
public interface OrderDomainEventGateway {

    boolean create(OrderBaseEvent orderBaseEvent);

}
