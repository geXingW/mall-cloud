package com.gexingw.mall.product.domain.model;

import com.gexingw.mall.common.core.domain.AggregationRoot;
import com.gexingw.mall.common.exception.ParamInvalidException;
import lombok.Data;

import java.math.BigDecimal;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 8:11
 */
@SuppressWarnings("unused")
@Data
public class Product implements AggregationRoot<Long> {

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

    public Product decrStock(Integer quantity) {
        if (quantity <= 0) {
            throw new ParamInvalidException("库存数量不能小于0");
        }

        if (quantity > this.stock) {
            throw new ParamInvalidException("库存不足！");
        }

        this.stock = this.stock - quantity;

        return this;
    }

}
