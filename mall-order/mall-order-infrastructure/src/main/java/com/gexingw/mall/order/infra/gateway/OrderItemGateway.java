package com.gexingw.mall.order.infra.gateway;

import com.gexingw.mall.order.infra.po.OrderItemPO;

/**
 * @author GeXingW
 */
public interface OrderItemGateway {

    void insert(OrderItemPO orderItemPO);

}
