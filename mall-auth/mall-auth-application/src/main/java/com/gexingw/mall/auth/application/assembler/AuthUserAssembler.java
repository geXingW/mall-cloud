package com.gexingw.mall.auth.application.assembler;

import com.gexingw.mall.auth.client.co.AuthUserCO;
import com.gexingw.mall.auth.client.command.user.UserRegisterCommand;
import com.gexingw.mall.auth.domain.model.AuthUser;
import com.gexingw.mall.auth.infrastructure.po.AuthUserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/12 13:08
 */
@Mapper
public interface AuthUserAssembler {

    AuthUserAssembler INSTANCE = Mappers.getMapper(AuthUserAssembler.class);

    AuthUserCO toCO(AuthUserPO authUserPO);

    AuthUser toDomain(UserRegisterCommand registerCommand);

}
