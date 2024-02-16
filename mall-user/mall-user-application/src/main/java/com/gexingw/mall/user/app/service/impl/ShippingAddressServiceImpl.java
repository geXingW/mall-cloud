package com.gexingw.mall.user.app.service.impl;

import com.gexingw.mall.user.app.service.ShippingAddressService;
import com.gexingw.mall.user.app.vo.address.ShippingAddressVO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/5 13:20
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Override
    public ShippingAddressVO getById(Long id) {
        return null;
    }

}
