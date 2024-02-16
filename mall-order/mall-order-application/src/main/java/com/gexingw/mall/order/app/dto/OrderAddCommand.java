package com.gexingw.mall.order.app.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/5 18:20
 */
@Data
public class OrderAddCommand implements Serializable {

    /**
     * 订单项信息
     */
    private List<OrderItem> items;

    /**
     * 金额信息
     */
    private BigDecimal amount;

    /**
     * 配送信息
     */
    private Shipping shipping;

    @Data
    @Accessors(chain = true)
    public static class OrderItem {

        private Long id;

        private Integer quantity;

    }

    @Data
    @Accessors(chain = true)
    public static class Shipping {

        private Long addressId;

    }

}
