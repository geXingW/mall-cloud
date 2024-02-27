package com.gexingw.mall.order.infra.gateway;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.common.core.enums.OrderRespCode;
import com.gexingw.mall.common.exception.BizErrorException;
import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.domain.gateway.OrderGateway;
import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.domain.order.model.OrderItem;
import com.gexingw.mall.order.infra.convert.order.OrderConvert;
import com.gexingw.mall.order.infra.convert.order.OrderItemDOConvert;
import com.gexingw.mall.order.infra.convert.order.OrderShippingAddressConvert;
import com.gexingw.mall.order.infra.dataobject.OrderDO;
import com.gexingw.mall.order.infra.dataobject.OrderItemDO;
import com.gexingw.mall.order.infra.dataobject.OrderShippingAddressDO;
import com.gexingw.mall.order.infra.gateway.db.OrderDomainEventMapper;
import com.gexingw.mall.order.infra.gateway.db.OrderItemMapper;
import com.gexingw.mall.order.infra.gateway.db.OrderMapper;
import com.gexingw.mall.order.infra.gateway.db.OrderShippingAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    private final OrderItemMapper orderItemMapper;
    private final OrderShippingAddressMapper orderShippingAddressMapper;

    private final OrderConvert orderConvert;
    private final OrderItemDOConvert orderItemDOConvert;
    private final OrderShippingAddressConvert orderShippingAddressConvert;

    @Override
    public Order find(Long id) {
        Order order = orderConvert.toDomain(orderMapper.selectById(id));
        if (order == null) {
            throw new BizNotFoundException(OrderRespCode.NOT_FOUND);
        }

        // 订单详情
        List<OrderItem> orderItems = orderItemMapper.selectList(new LambdaQueryWrapper<OrderItemDO>().eq(OrderItemDO::getOrderId, id))
                .stream().map(orderItemDOConvert::toDomain).collect(Collectors.toList());
        order.setItems(orderItems);

        // 订单收货地址
        LambdaQueryWrapper<OrderShippingAddressDO> queryWrapper = new LambdaQueryWrapper<OrderShippingAddressDO>()
                .eq(OrderShippingAddressDO::getOrderId, id);
        order.setShippingAddress(orderShippingAddressConvert.toDomain(orderShippingAddressMapper.selectOne(queryWrapper)));

        return order;
    }

    /**
     * 保存订单信息
     *
     * @param order 订单聚合
     * @return 订单Id
     */
    public Long insert(Order order) {
        OrderDO orderDO = orderConvert.toDO(order);
        // 保存订单主信息
        if (orderMapper.insert(orderDO) == 0) {
            throw new BizErrorException(OrderRespCode.SUBMIT_ERROR);
        }

        // 保存订单商品信息
        for (OrderItem item : order.getItems()) {
            if (orderItemMapper.insert(orderItemDOConvert.toDO(item)) == 0) {
                throw new BizErrorException(OrderRespCode.SUBMIT_ERROR);
            }
        }

        // 保存订单的收货地址信息
        if (orderShippingAddressMapper.insert(orderShippingAddressConvert.toDO(order.getShippingAddress())) == 0) {
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
        // 更新订单信息
        if (orderMapper.updateById(orderDO) == 0) {
            throw new BizErrorException(OrderRespCode.CANCEL_ERROR);
        }

        // 更新订单商品信息
        for (OrderItem item : order.getItems()) {
            if (orderItemMapper.updateById(orderItemDOConvert.toDO(item)) == 0) {
                throw new BizErrorException(OrderRespCode.CANCEL_ERROR);
            }
        }

        // 保存订单的收货地址信息
        if (orderShippingAddressMapper.updateById(orderShippingAddressConvert.toDO(order.getShippingAddress())) == 0) {
            throw new BizErrorException(OrderRespCode.CANCEL_ERROR);
        }

        return false;
    }

    /**
     * 删除订单
     *
     * @param id 订单Id
     * @return 删除结果
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(Long id) {
        // 删除订单信息
        if (orderMapper.deleteById(id) == 0) {
            throw new BizErrorException(OrderRespCode.DELETE_ERROR);
        }

        // 删除订单商品信息
        if (orderItemMapper.delete(new LambdaQueryWrapper<OrderItemDO>().eq(OrderItemDO::getOrderId, id)) == 0) {
            throw new BizErrorException(OrderRespCode.DELETE_ERROR);
        }

        // 删除订单收获地址信息
        if (orderShippingAddressMapper.delete(new LambdaQueryWrapper<OrderShippingAddressDO>().eq(OrderShippingAddressDO::getOrderId, id)) == 0) {
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
