package com.gexingw.mall.auth.application.assembler;

import com.gexingw.mall.auth.application.vo.RegisteredClientCreateResultVO;
import org.mapstruct.Mapper;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/6/6 22:08
 */
@Mapper(componentModel = "spring")
public interface RegisteredClientAssembler {

    RegisteredClientCreateResultVO toCreateResultVO(RegisteredClient registeredClient);

}
