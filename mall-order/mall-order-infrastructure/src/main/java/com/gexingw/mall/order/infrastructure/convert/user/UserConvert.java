package com.gexingw.mall.order.infrastructure.convert.user;

import com.gexingw.mall.common.core.convert.DomainDoConvert;
import com.gexingw.mall.domain.user.model.User;
import com.gexingw.mall.user.client.clientobject.user.UserCO;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/15 13:17
 */
@Mapper(componentModel = "spring")
public interface UserConvert extends DomainDoConvert<User, UserCO> {
}
