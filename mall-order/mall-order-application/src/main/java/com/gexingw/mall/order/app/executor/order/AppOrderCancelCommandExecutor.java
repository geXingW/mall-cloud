package com.gexingw.mall.order.app.executor.order;

import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommand;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import com.gexingw.mall.common.spring.event.EventBus;
import com.gexingw.mall.domain.event.order.OrderCanceledEvent;
import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.domain.service.OrderDomainService;
import com.gexingw.mall.order.app.command.order.AppOrderCancelCommand;
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
public class AppOrderCancelCommandExecutor implements ICommandExecutor {

    private final OrderDomainService orderDomainService;

    private final EventBus eventBus;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void handleWithoutResult(ICommand iCommand) {
        AppOrderCancelCommand command = (AppOrderCancelCommand) iCommand;

        // 查找聚合
        Order order = orderDomainService.find(command.getId());
        // 保存聚合信息
        orderDomainService.save(order.cancel());

        // 发送订单取消的事件
        eventBus.publish(new OrderCanceledEvent(order));

    }

}
