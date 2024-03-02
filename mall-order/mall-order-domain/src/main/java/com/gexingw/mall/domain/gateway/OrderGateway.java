package com.gexingw.mall.domain.gateway;

import com.gexingw.mall.domain.order.model.Order;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:13
 */
public interface OrderGateway {

    @SuppressWarnings("unused")
    Order getById(Long id);

    boolean exist(Long id);

    Long insert(Order cancel);

}
