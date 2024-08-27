package com.gexingw.mall.user.app.assembler;

import com.gexingw.mall.user.app.vo.web.mall.auth.WebMallAuthInfoVO;
import com.gexingw.mall.user.infra.dao.user.po.UserPO;
import org.mapstruct.Mapper;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/27 11:25
 */
@Mapper(componentModel = "spring")
public interface AuthAssembler {

    WebMallAuthInfoVO toWebMallInfoVO(UserPO userPO);

}
