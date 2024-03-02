package com.gexingw.mall.domain.service;

import com.gexingw.mall.domain.order.model.Order;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/6 16:16
 */
public interface OrderDomainService {

    Long save(Order order);

    Boolean update(Order order);

    boolean delete(Long id);

    Order find(Long id);

}
