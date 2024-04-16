package com.gexingw.mall.order.infrastructure.convert.order;

import com.gexingw.mall.domain.model.order.OrderOperator;
import com.gexingw.mall.domain.user.model.User;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/15 13:23
 */
@Mapper(componentModel = "spring")
public interface OrderOperatorConvert {

    OrderOperator toDomain(User user);

}
