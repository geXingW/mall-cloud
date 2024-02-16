package com.gexingw.mall.order.app.service.impl;

import com.gexingw.mall.order.app.command.executor.OrderCommandExecutor;
import com.gexingw.mall.order.app.dto.OrderAddCommand;
import com.gexingw.mall.order.app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/6 10:49
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderServiceImpl implements OrderService {

    private final OrderCommandExecutor commandExecutor;

    @Override
    public Long add(OrderAddCommand addCommand) {
        return commandExecutor.add(addCommand);
    }

}
