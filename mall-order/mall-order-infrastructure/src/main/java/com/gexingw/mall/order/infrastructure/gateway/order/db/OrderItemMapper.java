package com.gexingw.mall.order.infrastructure.gateway.order.db;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gexingw.mall.order.infrastructure.po.OrderItemPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:59
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItemPO> {

}
