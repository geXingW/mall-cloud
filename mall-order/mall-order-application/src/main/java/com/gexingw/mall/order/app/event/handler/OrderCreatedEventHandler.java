package com.gexingw.mall.order.app.event.handler;

import com.gexingw.mall.common.spring.event.EventHandler;
import com.gexingw.mall.common.spring.event.IEvent;
import com.gexingw.mall.common.spring.event.IEventHandler;
import com.gexingw.mall.domain.event.order.OrderCreatedEvent;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 17:13
 */
@EventHandler({OrderCreatedEvent.class})
public class OrderCreatedEventHandler implements IEventHandler {

    @Override
    public Boolean handle(IEvent event) {
        return null;
    }

}
