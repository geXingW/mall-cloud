package com.gexingw.mall.product.infrastructure.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 18:01
 */
@Data
public class ProductListDTO implements Serializable {

    private Long id;

    private String number;

    private String name;

    private Integer stock;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

}
