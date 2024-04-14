package com.gexingw.mall.order.infrastructure.convert.order;

import com.gexingw.mall.common.core.convert.DomainPOConvert;
import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.order.infrastructure.po.OrderPO;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 17:21
 */
@Mapper(componentModel = "spring")
public interface OrderConvert extends DomainPOConvert<Order, OrderPO> {

}
