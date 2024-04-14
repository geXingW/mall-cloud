package com.gexingw.mall.order.infrastructure.convert.address;

import com.gexingw.mall.common.core.convert.DomainPOConvert;
import com.gexingw.mall.domain.model.address.ShippingAddress;
import com.gexingw.mall.order.infrastructure.po.ShippingAddressPO;
import org.mapstruct.Mapper;

/**
 * @author GeXingW
 */
@Mapper(componentModel = "spring")
public interface ShippingAddressConvert extends DomainPOConvert<ShippingAddress, ShippingAddressPO> {

}
