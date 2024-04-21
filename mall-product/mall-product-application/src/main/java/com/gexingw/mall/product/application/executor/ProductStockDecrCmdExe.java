package com.gexingw.mall.product.application.executor;

import com.gexingw.mall.common.core.support.ICommand;
import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import com.gexingw.mall.product.application.commd.product.ProductStockDecrCommand;
import com.gexingw.mall.product.domain.model.Product;
import com.gexingw.mall.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/17 13:43
 */
@CommandHandler(ProductStockDecrCommand.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProductStockDecrCmdExe implements ICommandExecutor {

    private final ProductRepository productRepository;

    @Override
    public void handleWithoutResult(ICommand command) {
        ProductStockDecrCommand decrCommand = (ProductStockDecrCommand) command;
        Product product = productRepository.find(decrCommand.getProductId());
        if (product == null) {
            throw new BizNotFoundException("商品不存在！");
        }

        product.decrStock(decrCommand.getQuantity());
        productRepository.save(product);
    }

}
