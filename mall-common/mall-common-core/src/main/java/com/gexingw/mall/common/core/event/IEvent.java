package com.gexingw.mall.common.core.event;

import com.gexingw.mall.common.core.domain.AggregationRoot;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 15:28
 */
public interface IEvent {

    Long getIdentity();

    String getType();

    AggregationRoot getPayload();

}
