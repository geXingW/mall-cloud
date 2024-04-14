package com.gexingw.mall.order.app.vo.order;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String number;

    private BigDecimal totalAmount;

    private Integer totalQuantity;

}
