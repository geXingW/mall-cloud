package com.gexingw.mall.order.infra.gateway;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gexingw.mall.common.core.enums.OrderRespCode;
import com.gexingw.mall.common.exception.BizErrorException;
import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.order.infra.convert.order.OrderConvert;
import com.gexingw.mall.order.infra.dataobject.OrderDO;
import com.gexingw.mall.order.infra.gateway.db.OrderMapper;
import com.gexingw.mall.order.infra.po.OrderPO;
import com.gexingw.mall.order.infra.query.order.AppOrderQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:16
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderGatewayImpl implements OrderGateway {

    private final OrderMapper orderMapper;
    private final OrderConvert orderConvert;

    @Override
    public void insert(OrderPO orderPO) {
        orderMapper.insert(orderPO);
    }

    @Override
    public IPage<OrderPO> queryAppList(AppOrderQuery query) {
        Page<OrderPO> page = new Page<>(query.getPage(), query.getSize());
        return orderMapper.queryAppList(page, query);
    }

    @Override
    public OrderPO getById(Long id) {
        return null;
    }

    @Override
    public boolean exist(Long id) {
        return false;
    }
}
