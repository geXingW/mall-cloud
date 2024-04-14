package com.gexingw.mall.order.infrastructure.gateway.order.db;

import com.gexingw.mall.common.db.mapper.BaseMapper;
import com.gexingw.mall.order.infrastructure.dataobject.OrderDomainEventDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 16:50
 */
@Mapper
public interface OrderDomainEventMapper extends BaseMapper<OrderDomainEventDO> {

}
