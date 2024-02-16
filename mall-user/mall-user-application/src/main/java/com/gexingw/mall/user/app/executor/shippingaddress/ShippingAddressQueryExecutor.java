package com.gexingw.mall.user.app.executor.shippingaddress;

import com.gexingw.mall.user.app.assembler.ShippingAddressAssembler;
import com.gexingw.mall.user.app.vo.address.ShippingAddressListVO;
import com.gexingw.mall.user.app.vo.address.ShippingAddressVO;
import com.gexingw.mall.user.domain.address.ShippingAddressGateway;
import com.gexingw.mall.user.domain.address.dto.ShippingAddressListQuery;
import com.gexingw.mall.user.domain.address.model.ShippingAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/8 15:21
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ShippingAddressQueryExecutor {

    private final ShippingAddressGateway shippingAddressGateway;
    private final ShippingAddressAssembler shippingAddressAssembler;

    public List<ShippingAddressListVO> execute(ShippingAddressListQuery query) {
        List<ShippingAddress> shippingAddresses = shippingAddressGateway.queryList(query);

        return shippingAddresses.stream().map(shippingAddressAssembler::toVO).collect(Collectors.toList());
    }

    @SuppressWarnings("unused")
    public ShippingAddressVO getById(Long id) {
        ShippingAddress shippingAddress = shippingAddressGateway.getById(id);

        return new ShippingAddressVO().setId(shippingAddress.getId()).setName(shippingAddress.getName()).setProvince(shippingAddress.getProvince());
    }

}
