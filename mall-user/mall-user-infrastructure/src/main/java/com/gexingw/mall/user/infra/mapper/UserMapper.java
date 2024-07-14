package com.gexingw.mall.user.infra.mapper;

import com.gexingw.mall.common.db.mapper.BaseMapper;
import com.gexingw.mall.user.infra.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/12 23:18
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

}
