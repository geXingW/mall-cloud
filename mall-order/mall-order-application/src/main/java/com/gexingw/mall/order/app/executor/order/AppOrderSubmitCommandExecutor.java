package com.gexingw.mall.order.app.executor.order;

import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommand;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import com.gexingw.mall.domain.gateway.ShippingAddressGateway;
import com.gexingw.mall.domain.model.address.ShippingAddress;
import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.domain.order.model.OrderItem;
import com.gexingw.mall.domain.order.model.OrderShippingAddress;
import com.gexingw.mall.domain.repository.order.OrderRepository;
import com.gexingw.mall.order.app.assembler.OrderItemAssembler;
import com.gexingw.mall.order.app.assembler.OrderShippingAddressAssembler;
import com.gexingw.mall.order.app.command.order.AppOrderSubmitCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * mall-user-service
 * App端订单提交命令 {@link AppOrderSubmitCommand} 处理器
 *
 * @author GeXingW
 * @date 2024/2/24 21:28
 */
@CommandHandler(AppOrderSubmitCommand.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AppOrderSubmitCommandExecutor implements ICommandExecutor {

    private final ShippingAddressGateway shippingAddressGateway;

    private final OrderItemAssembler orderItemAssembler;
    private final OrderShippingAddressAssembler orderShippingAddressAssembler;

    private final OrderRepository orderRepository;

    @Override
    public Long handleWithResult(ICommand command) {
        AppOrderSubmitCommand submitCommand = (AppOrderSubmitCommand) command;

        // 查询发货信息i
        ShippingAddress shippingAddress = shippingAddressGateway.find(submitCommand.getShipping().getAddressId());
        if (shippingAddress == null) {
            throw new BizNotFoundException("收货地址不存在！");
        }

        OrderShippingAddress orderShippingAddress = orderShippingAddressAssembler.fromShippingAddress(shippingAddress);

        // 构造订单商品信息
        List<OrderItem> orderItems = submitCommand.getItems().stream().map(orderItemAssembler::toOrderItem).collect(Collectors.toList());
        Order order = new Order(orderItems, null, orderShippingAddress);
        orderRepository.save(order);

        return order.getId();
    }

}
