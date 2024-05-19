package com.gexingw.mall.auth.infrastructure.convert;

import com.gexingw.mall.auth.domain.model.RegisteredClient;
import com.gexingw.mall.auth.infrastructure.po.RegisteredClientPO;
import com.gexingw.mall.common.core.convert.DomainPOConvert;
import org.mapstruct.Mapper;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 13:14
 */
@Mapper(componentModel = "spring")
public interface RegisteredClientConvert extends DomainPOConvert<RegisteredClient, RegisteredClientPO> {

    @Override
//    @Mapping(target = "scopes", expression = "java(scopesToString(registeredClient.getScopes()))")
    RegisteredClientPO toPO(RegisteredClient registeredClient);

    @Override
//    @Mapping(target = "scopes", expression = "java(stringToScopes(registeredClientPO.getScopes()))")
    RegisteredClient toDomain(RegisteredClientPO registeredClientPO);

    default String scopesToString(Set<String> scopes) {
        return String.join(",", scopes);
    }

    default Set<String> stringToScopes(String scopes) {
        return Arrays.stream(scopes.split(",")).collect(Collectors.toSet());
    }

}
