package com.gexingw.mall.user.infra.convert;

import com.gexingw.mall.user.domain.user.User;
import com.gexingw.mall.user.infra.config.MapStructConfig;
import com.gexingw.mall.user.infra.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/12 23:26
 */
@Mapper(config = MapStructConfig.class)
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    User toDomain(UserPO userPO);

    UserPO toPO(User user);

}
