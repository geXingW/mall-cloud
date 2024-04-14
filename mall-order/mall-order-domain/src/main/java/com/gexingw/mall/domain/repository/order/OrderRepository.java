package com.gexingw.mall.domain.repository.order;

import com.gexingw.mall.domain.order.model.Order;

/**
 * @author GeXingW
 */
public interface OrderRepository {

    void save(Order order);

}
