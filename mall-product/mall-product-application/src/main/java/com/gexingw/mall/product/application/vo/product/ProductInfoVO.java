package com.gexingw.mall.product.application.vo.product;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/11 13:45
 */
@Data
public class ProductInfoVO implements Serializable {

    private Long id;

    private String name;

    private Integer stock;

    private Integer soldStock;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

}
