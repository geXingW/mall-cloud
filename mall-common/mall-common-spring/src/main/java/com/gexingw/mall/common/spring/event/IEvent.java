package com.gexingw.mall.common.spring.event;

import top.gexingw.ddd.core.AggregateRoot;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 15:28
 */
public interface IEvent {

    Long getIdentity();

    String getType();

    AggregateRoot getPayload();

}
