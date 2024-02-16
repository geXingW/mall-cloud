package com.gexingw.mall.order.app.service;

import com.gexingw.mall.order.app.dto.OrderAddCommand;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/5 18:27
 */
public interface OrderService {

    @SuppressWarnings("unused")
    Long add(OrderAddCommand addCommand);

}
