package com.gexingw.mall.order.infra.repository;

import cn.hutool.core.util.RandomUtil;
import com.gexingw.mall.order.infra.gateway.OrderGateway;
import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.domain.repository.OrderRepository;
import com.gexingw.mall.order.infra.gateway.OrderItemGateway;
import com.gexingw.mall.order.infra.po.OrderItemPO;
import com.gexingw.mall.order.infra.po.OrderPO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

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
        OrderPO orderPO = new OrderPO().setNumber(RandomUtil.randomString(10)).setTotalAmount(BigDecimal.valueOf(10))
                .setTotalQuantity(1);
        orderGateway.insert(orderPO);
        order.setId(orderPO.getId());

        // 保存订单商品信息
        order.getItems().forEach(orderItem -> {
            OrderItemPO orderItemPO = new OrderItemPO().setOrderId(orderPO.getId()).setQuantity(orderItem.getQuantity())
                    .setProductId(orderItem.getProductId());
            orderItemGateway.insert(orderItemPO);
        });

    }

}
