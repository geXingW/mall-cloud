package com.gexingw.mall.auth.infrastructure.gateway.authuser.db;

import com.gexingw.mall.auth.infrastructure.po.GroupUserPO;
import com.gexingw.mall.common.db.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/17 13:35
 */
@Mapper
public interface GroupUserMapper extends BaseMapper<GroupUserPO> {

}
