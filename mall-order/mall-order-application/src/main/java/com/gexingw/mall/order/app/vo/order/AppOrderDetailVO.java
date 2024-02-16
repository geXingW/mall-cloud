package com.gexingw.mall.order.app.vo.order;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/15 16:05
 */
@Data
public class AppOrderDetailVO implements Serializable {

    private Long id;

    private String number;

    private BigDecimal totalAmount;

    private Integer totalQuantity;

    private List<Item> items;

    private ShippingAddress shippingAddress;

    @Data
    public static class Item {

        private Long productId;

        private String name;

        private BigDecimal unitPrice;

        private Integer quantity;

    }

    @Data
    public static class ShippingAddress {

        private Long addressId;

        private String name;

        private String details;

    }

}
