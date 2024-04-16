package com.gexingw.mall.order.infrastructure.po.product;

import lombok.Data;

import java.math.BigDecimal;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 18:31
 */
@Data
public class ProductPO {

    private Long id;

    private String number;

    private String name;

    private Integer stock;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

}
