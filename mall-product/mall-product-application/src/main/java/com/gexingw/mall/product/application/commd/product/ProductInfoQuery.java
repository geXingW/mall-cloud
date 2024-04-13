package com.gexingw.mall.product.application.commd.product;

import com.gexingw.mall.common.spring.command.ICommand;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/11 13:49
 */
@Data
@Accessors(chain = true)
public class ProductInfoQuery implements ICommand {

    private Long id;

}
