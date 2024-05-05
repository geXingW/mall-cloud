package com.gexingw.mall.order.app.executor.address;

import com.gexingw.mall.common.core.support.ICommand;
import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import com.gexingw.mall.domain.model.address.ShippingAddress;
import com.gexingw.mall.domain.repository.address.ShippingAddressRepository;
import com.gexingw.mall.order.app.assembler.ShippingAddressAssembler;
import com.gexingw.mall.order.app.command.address.ShippingAddressSaveCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

/**
 * @author GeXingW
 */
@CommandHandler(ShippingAddressSaveCmd.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ShippingAddressSaveCmdExe implements ICommandExecutor {

    private final ShippingAddressRepository shippingAddressRepository;

    private final ShippingAddressAssembler shippingAddressAssembler;

    @Override
    public Long handleWithResult(ICommand command) {
        ShippingAddress shippingAddress = shippingAddressAssembler.toDomain((ShippingAddressSaveCmd) command);
        return shippingAddressRepository.save(shippingAddress);
    }

}

