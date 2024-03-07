package com.gexingw.mall.product.application.commd.product;

import com.gexingw.mall.common.core.command.CommandHandler;
import com.gexingw.mall.common.core.command.ICommand;
import com.gexingw.mall.common.core.command.ICommandHandler;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 13:39
 */
@CommandHandler(ProductAddCommand.class)
public class ProductAddCommandExecutor implements ICommandHandler {

    @Override
    public <T> T execute(ICommand command, Class<T> responseType) {
        return null;
    }

}
