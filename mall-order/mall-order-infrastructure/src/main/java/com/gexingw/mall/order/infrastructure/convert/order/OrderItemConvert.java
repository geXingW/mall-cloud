package com.gexingw.mall.order.infrastructure.convert.order;

import com.gexingw.mall.common.core.convert.DomainPOConvert;
import com.gexingw.mall.domain.model.order.OrderItem;
import com.gexingw.mall.order.infrastructure.po.OrderItemPO;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 17:06
 */
@Mapper(componentModel = "spring")
public interface OrderItemConvert extends DomainPOConvert<OrderItem, OrderItemPO> {

    @Override
    OrderItemPO toPO(OrderItem orderItem);
}
