package com.gexingw.mall.product.application.commd.product;

import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import com.gexingw.mall.product.application.vo.product.ProductInfoVO;
import com.gexingw.mall.product.domain.gateway.ProductGateway;
import com.gexingw.mall.product.domain.model.Product;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/11 13:50
 */
@CommandHandler(ProductInfoQuery.class)
public class ProductInfoQueryExecutor implements ICommandExecutor {

    private ProductGateway productGateway;

    @Override
    public ProductInfoVO handleWithResult(ProductInfoQuery query) {
        Product product = productGateway.getById(query.getId());
    }

}
