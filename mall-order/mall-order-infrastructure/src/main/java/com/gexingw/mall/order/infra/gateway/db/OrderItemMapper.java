package com.gexingw.mall.order.infra.gateway.db;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gexingw.mall.order.infra.dataobject.OrderItemDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:59
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItemDO> {

}
