package com.gexingw.mall.domain.gateway;

import com.gexingw.mall.domain.order.model.OrderShippingAddress;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/12 19:28
 */
public interface ShippingAddressGateway {

    OrderShippingAddress getById(Long id);

}
