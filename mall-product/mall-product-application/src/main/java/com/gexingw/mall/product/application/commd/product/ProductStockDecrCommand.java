package com.gexingw.mall.product.application.commd.product;

import com.gexingw.mall.common.core.support.ICommand;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/17 13:40
 */
@Data
@AllArgsConstructor
public class ProductStockDecrCommand implements ICommand {

    private Long productId;

    private Integer quantity;

}
