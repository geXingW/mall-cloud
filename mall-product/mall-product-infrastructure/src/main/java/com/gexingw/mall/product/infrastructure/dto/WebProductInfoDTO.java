package com.gexingw.mall.product.infrastructure.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author GeXingW
 */
@Data
public class WebProductInfoDTO implements Serializable {

    private Long id;

    private String number;

    private String name;

    private Integer stock;

    private Integer soldCount;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

    private List<Attribute> attributes;

    public static class Attribute {

        private Long id;

        private String name;

    }

}
