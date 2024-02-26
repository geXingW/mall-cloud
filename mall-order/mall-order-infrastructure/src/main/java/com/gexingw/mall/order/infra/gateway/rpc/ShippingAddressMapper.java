package com.gexingw.mall.order.infra.gateway.rpc;

import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.user.client.clientobject.address.ShippingAddressCO;
import com.gexingw.mall.user.client.dubbo.ShippingAddressRpcService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/12 19:25
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ShippingAddressMapper {

    @DubboReference
    private ShippingAddressRpcService shippingAddressRpcService;

    public ShippingAddressCO getById(Long id) {
        R<ShippingAddressCO> getResult = shippingAddressRpcService.getById(id);
        if(!getResult.isSuccess()) {
            return null;
        }

        return getResult.getData();
    }

}
