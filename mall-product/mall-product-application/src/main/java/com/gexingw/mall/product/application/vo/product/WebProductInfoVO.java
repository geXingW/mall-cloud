package com.gexingw.mall.product.application.vo.product;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author GeXingW
 */
@Data
public class WebProductInfoVO implements Serializable {

    private Long id;

    private String number;

    private String name;

    private Integer stock;

    private Integer soldCount;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

}
