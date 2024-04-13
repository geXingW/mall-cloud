package com.gexingw.mall.order.app.vo.order;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author GeXingW
 */
@Data
@Accessors
public class AppOrderListVO implements Serializable {

    private String number;

    private BigDecimal totalAmount;

    private Integer totalQuantity;

}
