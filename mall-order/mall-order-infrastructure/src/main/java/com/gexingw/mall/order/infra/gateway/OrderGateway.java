package com.gexingw.mall.order.infra.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gexingw.mall.order.infra.po.OrderPO;
import com.gexingw.mall.order.infra.query.order.AppOrderQuery;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:13
 */
public interface OrderGateway {

    @SuppressWarnings("unused")
    OrderPO getById(Long id);

    boolean exist(Long id);

    void insert(OrderPO orderPO);

    IPage<OrderPO> queryAppList(AppOrderQuery query);

}
