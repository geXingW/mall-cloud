package com.gexingw.mall.domain.repository.order;

import com.gexingw.mall.common.core.repository.Repository;
import com.gexingw.mall.domain.model.order.Order;

/**
 * @author GeXingW
 */
public interface OrderRepository extends Repository<Order> {

    @Override
    Boolean save(Order order);

}
