package com.gexingw.mall.order.infra.gateway.db;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gexingw.mall.order.infra.po.OrderPO;
import com.gexingw.mall.order.infra.query.order.AppOrderQuery;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:11
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderPO> {

    IPage<OrderPO> queryAppList(Page<OrderPO> page, AppOrderQuery query);

}
