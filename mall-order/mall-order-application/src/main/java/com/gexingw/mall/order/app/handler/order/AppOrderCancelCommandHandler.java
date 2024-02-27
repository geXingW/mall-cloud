package com.gexingw.mall.order.app.handler.order;

import com.gexingw.mall.common.core.command.CommandHandler;
import com.gexingw.mall.common.core.command.ICommand;
import com.gexingw.mall.common.core.command.ICommandHandler;
import com.gexingw.mall.common.core.event.EventBus;
import com.gexingw.mall.domain.event.order.OrderCanceledEvent;
import com.gexingw.mall.domain.gateway.OrderGateway;
import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.order.app.dto.order.AppOrderCancelCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 17:22
 */
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@CommandHandler(AppOrderCancelCommand.class)
public class AppOrderCancelCommandHandler implements ICommandHandler {

    private final OrderGateway orderGateway;
    private final EventBus eventBus;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public <T> T execute(ICommand iCommand, Class<T> responseType) {
        AppOrderCancelCommand command = (AppOrderCancelCommand) iCommand;

        // 查找聚合
        Order order = orderGateway.find(command.getId());
        // 保存聚合信息
        orderGateway.insert(order.cancel());

        // 发送订单取消的事件
        eventBus.publish(new OrderCanceledEvent(order));

        return null;
    }

}
