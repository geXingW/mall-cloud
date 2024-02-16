package com.gexingw.mall.user.infra.convert;

import com.gexingw.mall.comm.core.convert.DomainDoConvert;
import com.gexingw.mall.user.domain.address.model.ShippingAddress;
import com.gexingw.mall.user.infra.dataobject.ShippingAddressDO;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/8 15:16
 */
@Mapper(componentModel = "spring")
public interface ShippingAddressConvert extends DomainDoConvert<ShippingAddress, ShippingAddressDO> {

}
