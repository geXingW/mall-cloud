package com.gexingw.mall.order.app.assembler;

import com.gexingw.mall.domain.order.model.OrderItem;
import com.gexingw.mall.order.app.dto.OrderAddCommand;
import com.gexingw.mall.order.app.vo.order.AppOrderDetailVO;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/6 16:58
 */
@Mapper(componentModel = "spring")
public interface OrderItemAssembler {

    OrderItem toOrderItem(OrderAddCommand.OrderItem orderItem);

    AppOrderDetailVO.Item toAppVO(OrderItem orderItem);

}
