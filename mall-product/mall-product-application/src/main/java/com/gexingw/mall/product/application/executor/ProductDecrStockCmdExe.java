package com.gexingw.mall.product.application.executor;

import com.gexingw.mall.common.core.support.ICommand;
import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import com.gexingw.mall.product.client.command.DecrStockCommand;
import com.gexingw.mall.product.domain.model.Product;
import com.gexingw.mall.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.util.List;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/21 11:14
 */
@CommandHandler(DecrStockCommand.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProductDecrStockCmdExe implements ICommandExecutor {

    private final ProductRepository productRepository;

    @Override
    public void handleWithoutResult(ICommand command) {
        DecrStockCommand decrStockCommand = (DecrStockCommand) command;
        List<DecrStockCommand.Item> products = decrStockCommand.getItems();

        for (DecrStockCommand.Item item : products) {
            Product product = productRepository.find(item.getProductId());
            if (product == null) {
                throw new BizNotFoundException("商品不存在！");
            }

            product.decrStock(item.getStock());
            productRepository.save(product);
        }
    }

}
