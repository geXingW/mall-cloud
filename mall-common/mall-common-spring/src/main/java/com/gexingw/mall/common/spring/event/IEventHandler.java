package com.gexingw.mall.common.spring.event;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 16:24
 */
@SuppressWarnings("unused")
public interface IEventHandler {

    Boolean handle(IEvent event);

}
