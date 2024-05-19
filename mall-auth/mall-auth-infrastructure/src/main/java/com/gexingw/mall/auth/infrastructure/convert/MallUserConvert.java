package com.gexingw.mall.auth.infrastructure.convert;

import com.gexingw.mall.auth.domain.model.MallUser;
import com.gexingw.mall.auth.infrastructure.po.MallUserPO;
import com.gexingw.mall.common.core.convert.DomainPOConvert;
import org.mapstruct.Mapper;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/17 17:37
 */
@Mapper(componentModel = "spring")
public interface MallUserConvert extends DomainPOConvert<MallUser, MallUserPO> {

}
