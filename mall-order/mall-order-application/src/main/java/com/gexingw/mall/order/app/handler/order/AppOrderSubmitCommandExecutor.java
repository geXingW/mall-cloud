package com.gexingw.mall.order.app.handler.order;

import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommand;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import com.gexingw.mall.domain.gateway.ShippingAddressGateway;
import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.domain.order.model.OrderItem;
import com.gexingw.mall.domain.order.model.OrderShippingAddress;
import com.gexingw.mall.domain.repository.OrderRepository;
import com.gexingw.mall.order.app.assembler.OrderItemAssembler;
import com.gexingw.mall.order.app.dto.order.AppOrderSubmitCommand;
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

    private final OrderRepository orderRepository;

    @Override
    public Long handleWithResult(ICommand command) {
        AppOrderSubmitCommand submitCommand = (AppOrderSubmitCommand) command;

        // 查询发货信息
        OrderShippingAddress shippingAddress = shippingAddressGateway.getById(submitCommand.getShipping().getAddressId());
        // 构造订单商品信息
        List<OrderItem> orderItems = submitCommand.getItems().stream().map(orderItemAssembler::toOrderItem).collect(Collectors.toList());
        Order order = new Order(orderItems, null, shippingAddress);
        orderRepository.save(order);

        return order.getId();
    }

}
