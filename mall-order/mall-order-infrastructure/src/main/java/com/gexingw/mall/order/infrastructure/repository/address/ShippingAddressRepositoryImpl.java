package com.gexingw.mall.order.infrastructure.repository.address;

import com.gexingw.mall.domain.gateway.address.ShippingAddressGateway;
import com.gexingw.mall.domain.model.address.ShippingAddress;
import com.gexingw.mall.domain.repository.address.ShippingAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 15:23
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ShippingAddressRepositoryImpl implements ShippingAddressRepository {

    private final ShippingAddressGateway shippingAddressGateway;

    @Override
    public Long save(ShippingAddress shippingAddress) {
        return shippingAddressGateway.save(shippingAddress);
    }

}
