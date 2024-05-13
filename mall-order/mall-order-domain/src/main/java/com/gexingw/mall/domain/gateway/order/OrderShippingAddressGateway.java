package com.gexingw.mall.domain.gateway.order;

import com.gexingw.mall.domain.model.order.OrderShippingAddress;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/4 19:09
 */
public interface OrderShippingAddressGateway {

    OrderShippingAddress getByOrderId(Long orderId);

    Long save(OrderShippingAddress shippingAddress);

    boolean delete(Long id);

}
