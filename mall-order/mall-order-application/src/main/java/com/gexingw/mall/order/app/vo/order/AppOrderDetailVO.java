package com.gexingw.mall.order.app.vo.order;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
public class AppOrderDetailVO implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String number;

    private BigDecimal totalAmount;

    private Integer totalQuantity;

    private List<Item> items;

    private ShippingAddress shippingAddress;

    @Data
    public static class Item {

        @JsonSerialize(using = ToStringSerializer.class)
        private Long productId;

        private String name;

        private BigDecimal unitPrice;

        private Integer quantity;

    }

    @Data
    public static class ShippingAddress {

        @JsonSerialize(using = ToStringSerializer.class)
        private Long addressId;

        private String name;

        private String details;

    }

}
