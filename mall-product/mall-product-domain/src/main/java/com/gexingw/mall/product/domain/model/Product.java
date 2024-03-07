package com.gexingw.mall.product.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 8:11
 */
@SuppressWarnings("unused")
@Data
public class Product implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 商品编号
     */
    private String number;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品库存
     */
    private Integer stock;

    /**
     * 已售数量
     */
    private Integer soldCount;

    /**
     * 售价
     */
    private BigDecimal salePrice;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

}
