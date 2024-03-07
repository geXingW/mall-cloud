package com.gexingw.mall.product.application.commd.product;

import com.gexingw.mall.common.core.command.CommandHandler;
import com.gexingw.mall.common.core.command.ICommand;
import com.gexingw.mall.common.core.command.ICommandHandler;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/7 13:36
 */
@CommandHandler(ProductListQuery.class)
public class ProductListQueryExecutor implements ICommandHandler {

    @Override
    public <T> T execute(ICommand command, Class<T> responseType) {
        return ICommandHandler.super.execute(command, responseType);
    }
}