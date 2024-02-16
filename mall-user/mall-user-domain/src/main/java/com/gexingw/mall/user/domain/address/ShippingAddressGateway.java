package com.gexingw.mall.user.domain.address;

import com.gexingw.mall.user.domain.address.dto.ShippingAddressListQuery;
import com.gexingw.mall.user.domain.address.model.ShippingAddress;

import java.util.List;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/5 13:43
 */
public interface ShippingAddressGateway {

    ShippingAddress getById(Long id);

    boolean insert(ShippingAddress shippingAddress);

    List<ShippingAddress> queryList(ShippingAddressListQuery query);
}
