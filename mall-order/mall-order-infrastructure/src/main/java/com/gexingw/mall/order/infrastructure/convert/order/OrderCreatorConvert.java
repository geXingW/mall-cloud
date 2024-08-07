package com.gexingw.mall.order.infrastructure.convert.order;

import com.gexingw.mall.domain.model.order.OrderCreator;
import com.gexingw.mall.user.client.clientobject.user.UserCO;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 22:40
 */
@Mapper(componentModel = "spring")
public interface OrderCreatorConvert {

    OrderCreator toDomain(UserCO userCo);

}
