package com.gexingw.mall.order.infra.gateway.db;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gexingw.mall.order.infra.dataobject.OrderShippingAddressDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/6 17:05
 */
@Mapper
public interface OrderShippingAddressMapper extends BaseMapper<OrderShippingAddressDO> {

}
