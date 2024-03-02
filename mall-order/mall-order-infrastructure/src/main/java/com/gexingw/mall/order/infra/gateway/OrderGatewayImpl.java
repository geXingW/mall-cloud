package com.gexingw.mall.order.infra.gateway;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.common.core.enums.OrderRespCode;
import com.gexingw.mall.common.exception.BizErrorException;
import com.gexingw.mall.domain.gateway.OrderGateway;
import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.order.infra.convert.order.OrderConvert;
import com.gexingw.mall.order.infra.convert.order.OrderItemDOConvert;
import com.gexingw.mall.order.infra.convert.order.OrderShippingAddressConvert;
import com.gexingw.mall.order.infra.dataobject.OrderDO;
import com.gexingw.mall.order.infra.gateway.db.OrderItemMapper;
import com.gexingw.mall.order.infra.gateway.db.OrderMapper;
import com.gexingw.mall.order.infra.gateway.db.OrderShippingAddressMapper;
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

    /**
     * 保存订单信息
     *
     * @param order 订单聚合
     * @return 订单Id
     */
    public Long insert(Order order) {
        OrderDO orderDO = orderConvert.toDO(order);
        if (orderMapper.insert(orderDO) == 0) {
            throw new BizErrorException(OrderRespCode.SUBMIT_ERROR);
        }

        return orderDO.getId();
    }

    /**
     * 更新订单
     *
     * @param order 订单聚合
     * @return 更新结果
     */
    public Boolean update(Order order) {
        OrderDO orderDO = orderConvert.toDO(order);
        if ((orderMapper.updateById(orderDO) == 0)) {
            throw new BizErrorException(OrderRespCode.SUBMIT_ERROR);
        }

        return true;
    }

    /**
     * 删除订单
     *
     * @param id 订单Id
     * @return 删除结果
     */
    public Boolean delete(Long id) {
        // 删除订单信息
        if (orderMapper.deleteById(id) == 0) {
            throw new BizErrorException(OrderRespCode.DELETE_ERROR);
        }

        return true;
    }

    @Override
    public Order getById(Long id) {
        OrderDO orderDO = orderMapper.selectById(id);
        if (orderDO == null) {
            return null;
        }

        return orderConvert.toDomain(orderDO);
    }

    @Override
    public boolean exist(Long id) {
        return orderMapper.exists(new LambdaQueryWrapper<OrderDO>().eq(OrderDO::getId, id));
    }

}
