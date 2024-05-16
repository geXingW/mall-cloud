package com.gexingw.mall.auth.infrastructure.conver;

import com.gexingw.mall.auth.domain.model.AuthRegisteredClient;
import com.gexingw.mall.auth.infrastructure.po.RegisteredClientPO;
import com.gexingw.mall.common.core.convert.DomainPOConvert;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 13:14
 */
@Mapper(componentModel = "spring")
public interface RegisteredClientConvert extends DomainPOConvert<AuthRegisteredClient, RegisteredClientPO> {


}
