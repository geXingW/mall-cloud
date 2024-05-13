package com.gexingw.mall.domain.gateway.order;

import com.gexingw.mall.domain.model.order.OrderItem;

import java.util.List;
import java.util.Set;

/**
 * @author GeXingW
 */
public interface OrderItemGateway {

    Long insert(OrderItem orderItem);

    List<OrderItem> queryByOrderId(Long id);

    boolean delete(Set<Long> ids);

}
