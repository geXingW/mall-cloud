package com.gexingw.mall.user.infra.gatewayimpl.db;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gexingw.mall.user.infra.dataobject.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/23 14:46
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {


}
