package com.gexingw.mall.user.app.assembler;

import com.gexingw.mall.auth.client.co.TokenInfoCO;
import com.gexingw.mall.user.app.vo.mall.AppAuthLoginVO;
import com.gexingw.mall.user.domain.auth.AuthToken;
import org.mapstruct.Mapper;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/5 11:56
 */
@Mapper(componentModel = "spring")
public interface MallAuthAssembler {

    AppAuthLoginVO toAppLoginVO(TokenInfoCO tokenInfoCO);

    AppAuthLoginVO toAppLoginVO(AuthToken authToken);

}
