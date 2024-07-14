package com.gexingw.mall.user.infra.convert;

import com.gexingw.mall.auth.client.co.AuthUserCO;
import com.gexingw.mall.user.domain.auth.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/12 13:31
 */
@Mapper
public interface AuthUserConvert {

    AuthUserConvert INSTANCE = Mappers.getMapper(AuthUserConvert.class);

    AuthUser toDomain(AuthUserCO authUserCO);

}
