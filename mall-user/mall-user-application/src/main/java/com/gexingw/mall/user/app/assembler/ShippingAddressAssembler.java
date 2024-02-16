package com.gexingw.mall.user.app.assembler;

import com.gexingw.mall.user.app.vo.address.ShippingAddressListVO;
import com.gexingw.mall.user.client.clientobject.address.ShippingAddressCO;
import com.gexingw.mall.user.domain.address.dto.ShippingAddressAddCommand;
import com.gexingw.mall.user.domain.address.model.ShippingAddress;
import com.gexingw.mall.user.infra.dataobject.ShippingAddressDO;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/8 14:33
 */
@Mapper(componentModel = "spring")
public interface ShippingAddressAssembler {

    ShippingAddress toDomain(ShippingAddressAddCommand addCommand);

    ShippingAddressListVO toVO(ShippingAddress shippingAddress);

    ShippingAddressCO toCo(ShippingAddressDO shippingAddressDO);

}
