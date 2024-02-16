package com.gexingw.mall.order.app.assembler;

import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.domain.order.model.OrderItem;
import com.gexingw.mall.domain.order.model.OrderShippingAddress;
import com.gexingw.mall.order.app.vo.order.AppOrderDetailVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/15 16:21
 */
@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface OrderAssembler {

    OrderItemAssembler ORDER_ITEM_ASSEMBLER = Mappers.getMapper(OrderItemAssembler.class);
    OrderShippingAddressAssembler ORDER_SHIPPING_ADDRESS_ASSEMBLER = Mappers.getMapper(OrderShippingAddressAssembler.class);

    @Mapping(target = "items", source = "orderItems")
    @Mapping(target = "shippingAddress", source = "orderShippingAddress", qualifiedByName = "toAppShippingAddressVO")
    AppOrderDetailVO toAppVO(Order order);

    @Named("toAppItemVO")
    default AppOrderDetailVO.Item toAppItemVO(OrderItem orderItem) {
        return ORDER_ITEM_ASSEMBLER.toAppVO(orderItem);
    }

    @Named("toAppShippingAddressVO")
    default AppOrderDetailVO.ShippingAddress toAppShippingAddressVO(OrderShippingAddress orderShippingAddress) {
        return ORDER_SHIPPING_ADDRESS_ASSEMBLER.toAppVO(orderShippingAddress);
    }

}
