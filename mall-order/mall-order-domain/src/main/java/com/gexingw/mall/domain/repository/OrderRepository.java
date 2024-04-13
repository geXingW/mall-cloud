package com.gexingw.mall.domain.repository;

import com.gexingw.mall.domain.order.model.Order;

public interface OrderRepository {


    void save(Order order);
}
