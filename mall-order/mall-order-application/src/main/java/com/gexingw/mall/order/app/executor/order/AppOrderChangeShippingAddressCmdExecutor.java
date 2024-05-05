package com.gexingw.mall.order.app.executor.order;

import com.gexingw.mall.common.core.support.ICommand;
import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import com.gexingw.mall.domain.gateway.address.ShippingAddressGateway;
import com.gexingw.mall.domain.model.address.ShippingAddress;
import com.gexingw.mall.domain.model.order.Order;
import com.gexingw.mall.domain.model.order.OrderShippingAddress;
import com.gexingw.mall.domain.repository.order.OrderRepository;
import com.gexingw.mall.order.app.assembler.OrderShippingAddressAssembler;
import com.gexingw.mall.order.app.command.order.AppOrderChangeShippingAddressCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/5 12:27
 */
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@CommandHandler(AppOrderChangeShippingAddressCmd.class)
public class AppOrderChangeShippingAddressCmdExecutor implements ICommandExecutor {

    private final OrderRepository orderRepository;

    private final ShippingAddressGateway shippingAddressGateway;

    private final OrderShippingAddressAssembler orderShippingAddressAssembler;

    @Override
    public void handleWithoutResult(ICommand command) {
        AppOrderChangeShippingAddressCmd changeShippingAddressCmd = (AppOrderChangeShippingAddressCmd) command;
        Order order = orderRepository.find(changeShippingAddressCmd.getId());
        if (order == null) {
            throw new BizNotFoundException("订单不存在");
        }

        // 检查收货地址是否存在
        ShippingAddress shippingAddress = shippingAddressGateway.find(changeShippingAddressCmd.getShippingAddressId());
        OrderShippingAddress orderShippingAddress = orderShippingAddressAssembler.fromShippingAddress(shippingAddress);

        // 修改订单收货地址
        order.changeShippingAddress(orderShippingAddress);
        if (!orderRepository.save(order)) {
            throw new RuntimeException("收货地址保存失败！");
        }
    }

}
