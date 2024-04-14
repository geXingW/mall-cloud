package com.gexingw.mall.order.app.assembler;

import com.gexingw.mall.domain.model.address.ShippingAddress;
import com.gexingw.mall.order.app.command.address.ShippingAddressSaveCmd;
import org.mapstruct.Mapper;

/**
 * @author GeXingW
 */
@Mapper(componentModel = "spring")
public interface ShippingAddressAssembler {

    ShippingAddress toDomain(ShippingAddressSaveCmd command);

}
