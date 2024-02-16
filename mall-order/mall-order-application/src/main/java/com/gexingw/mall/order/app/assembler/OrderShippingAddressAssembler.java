package com.gexingw.mall.order.app.assembler;

import com.gexingw.mall.domain.order.model.OrderShippingAddress;
import com.gexingw.mall.order.app.dto.OrderAddCommand;
import com.gexingw.mall.order.app.vo.order.AppOrderDetailVO;
import com.gexingw.mall.user.client.clientobject.address.ShippingAddressCO;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/6 17:01
 */
@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface OrderShippingAddressAssembler {

    OrderShippingAddress toShippingAddress(OrderAddCommand.Shipping shipping);

    OrderShippingAddress toShippingAddress(ShippingAddressCO shippingAddressCo);

    AppOrderDetailVO.ShippingAddress toAppVO(OrderShippingAddress orderShippingAddress);

}
