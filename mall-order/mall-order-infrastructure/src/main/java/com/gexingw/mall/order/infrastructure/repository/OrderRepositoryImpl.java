package com.gexingw.mall.order.infrastructure.repository;

import com.gexingw.mall.domain.gateway.OrderGateway;
import com.gexingw.mall.domain.gateway.OrderItemGateway;
import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.domain.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * @author GeXingW
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderGateway orderGateway;
    private final OrderItemGateway orderItemGateway;

    @Override
    public void save(Order order) {
        // 保存订单主信息
        Long orderId = orderGateway.insert(order);
        order.setId(orderId);

        // 保存订单商品信息
        order.getItems().forEach(orderItemGateway::insert);
    }

}
