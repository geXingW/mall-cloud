package com.gexingw.mall.user.infra.gatewayimpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.user.domain.address.dto.ShippingAddressListQuery;
import com.gexingw.mall.user.domain.address.model.ShippingAddress;
import com.gexingw.mall.user.domain.address.ShippingAddressGateway;
import com.gexingw.mall.user.infra.convert.ShippingAddressConvert;
import com.gexingw.mall.user.infra.gatewayimpl.db.ShippingAddressMapper;
import com.gexingw.mall.user.infra.dataobject.ShippingAddressDO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/5 13:43
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ShippingAddressGatewayImpl implements ShippingAddressGateway {

    private final ShippingAddressMapper shippingAddressMapper;
    private final ShippingAddressConvert shippingAddressConvert;

    @Override
    public ShippingAddress getById(Long id) {
        ShippingAddressDO address = shippingAddressMapper.selectById(id);

        return new ShippingAddress().setId(address.getId()).setProvince(address.getProvince());
    }

    @Override
    public boolean insert(ShippingAddress shippingAddress) {
        ShippingAddressDO shippingAddressDO = shippingAddressConvert.toDO(shippingAddress);

        return shippingAddressMapper.insert(shippingAddressDO) > 0;
    }

    @Override
    public List<ShippingAddress> queryList(ShippingAddressListQuery query) {
        LambdaQueryWrapper<ShippingAddressDO> queryWrapper = new LambdaQueryWrapper<ShippingAddressDO>().like(ShippingAddressDO::getName, query.getName());
        List<ShippingAddressDO> shippingAddressDoList = shippingAddressMapper.selectList(queryWrapper);

        return shippingAddressDoList.stream().map(shippingAddressConvert::toDomain).collect(Collectors.toList());
    }

}
