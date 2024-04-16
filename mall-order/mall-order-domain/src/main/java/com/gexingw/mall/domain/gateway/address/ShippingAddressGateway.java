package com.gexingw.mall.domain.gateway.address;

import com.gexingw.mall.domain.model.address.ShippingAddress;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/12 19:28
 */
public interface ShippingAddressGateway {

    ShippingAddress find(Long id);

    Long save(ShippingAddress shippingAddress);

}
