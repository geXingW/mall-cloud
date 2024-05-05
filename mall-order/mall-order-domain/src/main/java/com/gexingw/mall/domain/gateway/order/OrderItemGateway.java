package com.gexingw.mall.domain.gateway.order;

import com.gexingw.mall.domain.model.order.OrderItem;

import java.util.List;

/**
 * @author GeXingW
 */
public interface OrderItemGateway {

    Long insert(OrderItem orderItem);

    List<OrderItem> queryByOrderId(Long id);

}
