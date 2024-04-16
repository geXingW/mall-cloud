package com.gexingw.mall.order.infrastructure.convert.order;

import com.gexingw.mall.common.core.convert.DomainPOConvert;
import com.gexingw.mall.domain.model.order.OrderShippingAddress;
import com.gexingw.mall.order.infrastructure.po.ShippingAddressPO;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/6 17:13
 */
@Mapper(componentModel = "spring")
public interface OrderShippingAddressConvert extends DomainPOConvert<OrderShippingAddress, ShippingAddressPO> {

    @Override
    OrderShippingAddress toDomain(ShippingAddressPO shippingAddressCo);


}
