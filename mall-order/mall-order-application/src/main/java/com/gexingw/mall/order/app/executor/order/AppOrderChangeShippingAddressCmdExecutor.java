package com.gexingw.mall.order.app.executor.order;

import com.alibaba.fastjson.JSON;
import com.gexingw.mall.common.core.support.ICommand;
import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import com.gexingw.mall.domain.model.order.Order;
import com.gexingw.mall.domain.repository.order.OrderRepository;
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

    @Override
    public void handleWithoutResult(ICommand command) {
        AppOrderChangeShippingAddressCmd changeShippingAddressCmd = (AppOrderChangeShippingAddressCmd) command;
        Order order = orderRepository.find(changeShippingAddressCmd.getId());
        if (order == null) {
            throw new BizNotFoundException("订单不存在");
        }

        System.out.println(JSON.toJSONString(order));
    }

}
