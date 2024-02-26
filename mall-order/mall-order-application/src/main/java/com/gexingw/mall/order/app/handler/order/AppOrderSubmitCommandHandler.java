package com.gexingw.mall.order.app.handler.order;

import com.gexingw.mall.common.core.command.CommandHandler;
import com.gexingw.mall.common.core.command.ICommandHandler;
import com.gexingw.mall.common.core.command.ICommand;
import com.gexingw.mall.common.core.enums.OrderRespCode;
import com.gexingw.mall.common.exception.BizErrorException;
import com.gexingw.mall.domain.command.order.AppOrderSubmitCommand;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/24 21:28
 */
@CommandHandler(AppOrderSubmitCommand.class)
public class AppOrderSubmitCommandHandler implements ICommandHandler {

    @Override
    public <T> T execute(ICommand command, Class<T> responseType) {
        throw new BizErrorException(OrderRespCode.SUBMIT_ERROR);
    }

}
