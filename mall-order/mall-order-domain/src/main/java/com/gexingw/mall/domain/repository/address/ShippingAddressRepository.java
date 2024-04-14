package com.gexingw.mall.domain.repository.address;

import com.gexingw.mall.domain.model.address.ShippingAddress;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 15:21
 */
public interface ShippingAddressRepository {

    Long save(ShippingAddress shippingAddress);

}
