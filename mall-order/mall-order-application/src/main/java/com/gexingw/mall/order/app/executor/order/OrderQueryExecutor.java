package com.gexingw.mall.order.app.executor.order;

import com.gexingw.mall.domain.gateway.OrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/19 17:11
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderQueryExecutor {

    private final OrderGateway orderGateway;

}
