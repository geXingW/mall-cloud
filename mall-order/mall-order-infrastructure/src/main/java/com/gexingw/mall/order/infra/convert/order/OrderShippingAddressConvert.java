package com.gexingw.mall.order.infra.convert.order;

import com.gexingw.mall.common.core.convert.DomainDoConvert;
import com.gexingw.mall.domain.order.model.OrderShippingAddress;
import com.gexingw.mall.order.infra.dataobject.OrderShippingAddressDO;
import com.gexingw.mall.user.client.clientobject.address.ShippingAddressCO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/6 17:13
 */
@Mapper(componentModel = "spring")
public interface OrderShippingAddressConvert extends DomainDoConvert<OrderShippingAddress, OrderShippingAddressDO> {

    @Mapping(source = "address", target = "details")
    OrderShippingAddress toDomain(ShippingAddressCO shippingAddressCo);

}
