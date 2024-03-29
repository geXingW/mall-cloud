package com.gexingw.mall.product.infrastructure.po;

import com.gexingw.mall.common.db.dataobject.BaseDO;
import lombok.Data;

import java.math.BigDecimal;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 8:56
 */
@Data
public class ProductPO extends BaseDO {

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
