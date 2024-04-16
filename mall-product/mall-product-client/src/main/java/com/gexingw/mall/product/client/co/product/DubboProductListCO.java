package com.gexingw.mall.product.client.co.product;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 16:48
 */
@Data
public class DubboProductListCO implements Serializable {

    private Long id;

    private String number;

    private String name;

    private Integer stock;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

}
