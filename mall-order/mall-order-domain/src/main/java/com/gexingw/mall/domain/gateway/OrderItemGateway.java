package com.gexingw.mall.domain.gateway;

import com.gexingw.mall.domain.order.model.OrderItem;

/**
 * @author GeXingW
 */
public interface OrderItemGateway {

    Long insert(OrderItem orderItem);

}
