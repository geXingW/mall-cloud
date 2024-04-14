package com.gexingw.mall.order.infrastructure.gateway.order.db;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gexingw.mall.common.db.support.Pager;
import com.gexingw.mall.order.infrastructure.dto.order.AppOrderListDTO;
import com.gexingw.mall.order.infrastructure.po.OrderPO;
import com.gexingw.mall.order.infrastructure.query.order.AppOrderQuery;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:11
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderPO> {

    Pager<AppOrderListDTO> queryAppList(Pager<AppOrderListDTO> page, AppOrderQuery query);

}
