package com.gexingw.mall.order.infrastructure.dto.order;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author GeXingW
 */
@Data
public class AppOrderListDTO implements Serializable {

    private Long id;

    private String number;

    private BigDecimal totalAmount;

    private Integer totalQuantity;

    private LocalDateTime createTime;

}
