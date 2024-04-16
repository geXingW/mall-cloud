package com.gexingw.mall.order.infrastructure.repository;

import com.gexingw.mall.domain.gateway.order.OrderGateway;
import com.gexingw.mall.domain.gateway.order.OrderItemGateway;
import com.gexingw.mall.domain.model.order.Order;
import com.gexingw.mall.domain.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author GeXingW
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderGateway orderGateway;
    private final OrderItemGateway orderItemGateway;

    @Override
    @Transactional
    public void save(Order order) {
        // 保存订单主信息
        Long orderId = orderGateway.insert(order);
        order.setId(orderId);

        // 保存订单商品信息
        order.getItems().forEach(orderItemGateway::insert);
    }

}
