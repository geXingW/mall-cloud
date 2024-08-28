package com.gexingw.mall.auth.infrastructure.convert;

import com.gexingw.mall.auth.domain.model.AuthUser;
import com.gexingw.mall.auth.infrastructure.dao.authuser.po.AuthUserPO;
import com.gexingw.mall.common.core.convert.DomainPOConvert;
import org.mapstruct.Mapper;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 18:03
 */
@Mapper(componentModel = "spring")
public interface AuthUserConvert extends DomainPOConvert<AuthUser, AuthUserPO> {

}
