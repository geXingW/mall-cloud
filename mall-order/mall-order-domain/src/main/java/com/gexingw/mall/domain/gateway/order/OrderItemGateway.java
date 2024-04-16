package com.gexingw.mall.domain.gateway.order;

import com.gexingw.mall.domain.model.order.OrderItem;

/**
 * @author GeXingW
 */
public interface OrderItemGateway {

    Long insert(OrderItem orderItem);

}
