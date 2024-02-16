package com.gexingw.mall.domain.order.model;

import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:00
 */
@Data
public class OrderItem implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(OrderItem.class);

    private String name;

    private Long productId;

    private BigDecimal price;

    private Integer quantity;

    private String image;

    public BigDecimal getTotalAmount() {
        if (ObjectUtils.anyNull(price, quantity)) {
            log.warn("price or quantity is null. {}", this);
            return BigDecimal.ZERO;
        }

        return price.multiply(new BigDecimal(quantity));
    }

}
