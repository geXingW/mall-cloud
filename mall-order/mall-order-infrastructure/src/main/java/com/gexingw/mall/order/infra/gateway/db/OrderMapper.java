package com.gexingw.mall.order.infra.gateway.db;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gexingw.mall.order.infra.dataobject.OrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:11
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderDO> {

}
