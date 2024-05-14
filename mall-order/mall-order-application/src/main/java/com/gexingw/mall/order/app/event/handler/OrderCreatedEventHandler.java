package com.gexingw.mall.order.app.event.handler;

import com.alibaba.fastjson2.JSON;
import com.gexingw.mall.common.spring.event.EventHandler;
import com.gexingw.mall.domain.event.order.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 17:13
 */
@Component
@EventHandler({OrderCreatedEvent.class})
public class OrderCreatedEventHandler {

    @EventListener
    public Boolean handle(OrderCreatedEvent event) {
        System.out.println("收到订单创建成功事件：" + JSON.toJSONString(event));
        return true;
    }

}
