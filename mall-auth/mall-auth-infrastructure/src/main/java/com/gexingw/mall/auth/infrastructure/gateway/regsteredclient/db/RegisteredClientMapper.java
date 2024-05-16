package com.gexingw.mall.auth.infrastructure.gateway.regsteredclient.db;

import com.gexingw.mall.auth.infrastructure.po.RegisteredClientPO;
import com.gexingw.mall.common.db.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 13:02
 */
@Mapper
public interface RegisteredClientMapper extends BaseMapper<RegisteredClientPO> {

}
