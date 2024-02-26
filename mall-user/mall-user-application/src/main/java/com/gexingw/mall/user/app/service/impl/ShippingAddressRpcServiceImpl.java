package com.gexingw.mall.user.app.service.impl;

import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.user.app.assembler.ShippingAddressAssembler;
import com.gexingw.mall.user.client.clientobject.address.ShippingAddressCO;
import com.gexingw.mall.user.client.dubbo.ShippingAddressRpcService;
import com.gexingw.mall.user.infra.dataobject.ShippingAddressDO;
import com.gexingw.mall.user.infra.gatewayimpl.db.ShippingAddressMapper;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Lazy;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/12 19:32
 */
@DubboService
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ShippingAddressRpcServiceImpl implements ShippingAddressRpcService {

    private final ShippingAddressMapper shippingAddressMapper;
    private final ShippingAddressAssembler shippingAddressAssembler;

    @Override
    public R<ShippingAddressCO> getById(Long id) {
        ShippingAddressDO shippingAddressDO = shippingAddressMapper.selectById(id);
        if (shippingAddressDO == null) {
            throw new BizNotFoundException();
        }

        return R.ok(shippingAddressAssembler.toCo(shippingAddressDO));
    }

}
