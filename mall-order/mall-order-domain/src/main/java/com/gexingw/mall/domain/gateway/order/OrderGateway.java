package com.gexingw.mall.domain.gateway.order;

import com.gexingw.mall.domain.model.order.Order;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:13
 */
public interface OrderGateway {

    @SuppressWarnings("unused")
    Order selectById(Long id);

    boolean exist(Long id);

    Long insert(Order order);

    boolean delete(Long id);

    boolean update(Order order);

}
