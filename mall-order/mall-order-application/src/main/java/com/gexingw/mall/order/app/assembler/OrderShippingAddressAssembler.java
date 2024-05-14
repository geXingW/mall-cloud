package com.gexingw.mall.order.app.assembler;

import com.gexingw.mall.domain.model.address.ShippingAddress;
import com.gexingw.mall.domain.model.order.OrderShippingAddress;
import com.gexingw.mall.order.app.command.order.AppOrderAddCommand;
import com.gexingw.mall.order.app.vo.order.AppOrderDetailVO;
import org.jetbrains.annotations.NotNull;
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

    OrderShippingAddress toShippingAddress(AppOrderAddCommand.Shipping shipping);

    AppOrderDetailVO.ShippingAddress toAppVO(OrderShippingAddress orderShippingAddress);

    OrderShippingAddress fromShippingAddress(@NotNull ShippingAddress shippingAddress);

}
