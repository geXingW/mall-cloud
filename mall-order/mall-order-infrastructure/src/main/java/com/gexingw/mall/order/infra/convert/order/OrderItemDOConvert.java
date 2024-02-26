package com.gexingw.mall.order.infra.convert.order;

import com.gexingw.mall.common.core.convert.DomainDoConvert;
import com.gexingw.mall.domain.order.model.OrderItem;
import com.gexingw.mall.order.infra.dataobject.OrderItemDO;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 17:06
 */
@Mapper(componentModel = "spring")
public interface OrderItemDOConvert extends DomainDoConvert<OrderItem, OrderItemDO> {

}
