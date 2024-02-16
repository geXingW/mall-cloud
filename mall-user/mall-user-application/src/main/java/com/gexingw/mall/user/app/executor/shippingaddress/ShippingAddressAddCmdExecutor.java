package com.gexingw.mall.user.app.executor.shippingaddress;

import com.gexingw.mall.comm.core.enums.RespCode;
import com.gexingw.mall.common.exception.BizErrorException;
import com.gexingw.mall.user.app.assembler.ShippingAddressAssembler;
import com.gexingw.mall.user.domain.address.dto.ShippingAddressAddCommand;
import com.gexingw.mall.user.domain.address.model.ShippingAddress;
import com.gexingw.mall.user.domain.address.ShippingAddressGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/8 14:29
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ShippingAddressAddCmdExecutor {

    private final ShippingAddressGateway shippingAddressGateway;
    private final ShippingAddressAssembler shippingAddressAssembler;

    public Long execute(ShippingAddressAddCommand addCommand) {
        ShippingAddress shippingAddress = shippingAddressAssembler.toDomain(addCommand);
        if (!shippingAddressGateway.insert(shippingAddress)) {
            throw new BizErrorException(RespCode.SAVE_ERROR, "地址信息保存失败！");
        }

        return shippingAddress.getId();
    }

}
