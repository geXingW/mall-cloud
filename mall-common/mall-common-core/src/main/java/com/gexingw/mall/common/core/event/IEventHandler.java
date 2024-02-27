package com.gexingw.mall.common.core.event;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 16:24
 */
public interface IEventHandler {

    Boolean handle(IEvent event);

}
