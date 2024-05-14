package com.gexingw.mall.common.spring.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 17:06
 */
@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class EventBus {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(IEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}
