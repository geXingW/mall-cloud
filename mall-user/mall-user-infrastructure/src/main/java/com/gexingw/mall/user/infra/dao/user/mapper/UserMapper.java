package com.gexingw.mall.user.infra.dao.user.mapper;

import com.gexingw.mall.common.db.mapper.BaseMapper;
import com.gexingw.mall.user.infra.dao.user.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/26 13:20
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

}
