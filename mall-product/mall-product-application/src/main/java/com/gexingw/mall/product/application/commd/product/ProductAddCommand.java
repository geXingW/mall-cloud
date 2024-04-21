package com.gexingw.mall.product.application.commd.product;

import com.gexingw.mall.common.core.support.ICommand;
import lombok.Data;

import java.math.BigDecimal;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 8:09
 */
@Data
public class ProductAddCommand implements ICommand {

    private String name;

    private Integer stock;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

}
