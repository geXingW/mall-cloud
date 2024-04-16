package com.gexingw.mall.domain.model.product;

import com.gexingw.mall.common.core.domain.Entity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 16:12
 */
@Data
public class Product implements Entity {

    private Long id;

    private String number;

    private String name;

    private Integer stock;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

}
