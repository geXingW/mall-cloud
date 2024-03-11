package com.gexingw.mall.common.spring.event;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 17:44
 */
@SuppressWarnings("unused")
public interface IDomainEventService<Event extends IEvent> {

    boolean store(Event event);

    void broadcast(IEvent event);

}
