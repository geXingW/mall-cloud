package com.gexingw.mall.order.app.assembler;

import com.gexingw.mall.domain.order.model.OrderOperator;
import com.gexingw.mall.domain.user.model.User;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/15 13:25
 */
@Mapper(componentModel = "spring")
public interface OrderOperatorAssembler {

    OrderOperator toOrderOperator(User user);

}
