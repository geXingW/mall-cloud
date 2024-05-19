package com.gexingw.mall.auth.infrastructure.gateway.authuser.db;

import com.gexingw.mall.auth.infrastructure.po.MallUserPO;
import com.gexingw.mall.common.db.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 20:07
 */
@Mapper
public interface MallUserMapper extends BaseMapper<MallUserPO> {

}
