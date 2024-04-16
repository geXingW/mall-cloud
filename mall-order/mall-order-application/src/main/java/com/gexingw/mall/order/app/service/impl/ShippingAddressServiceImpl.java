package com.gexingw.mall.order.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gexingw.mall.common.db.support.PageData;
import com.gexingw.mall.common.spring.command.CommandBus;
import com.gexingw.mall.order.app.command.address.ShippingAddressSaveCmd;
import com.gexingw.mall.order.app.service.ShippingAddressService;
import com.gexingw.mall.order.infrastructure.dto.address.AppShippingAddressListDTO;
import com.gexingw.mall.order.infrastructure.gateway.address.db.ShippingAddressMapper;
import com.gexingw.mall.order.infrastructure.query.order.AppShippingAddressQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author GeXingW
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ShippingAddressServiceImpl implements ShippingAddressService {

    private final CommandBus commandBus;

    private final ShippingAddressMapper shippingAddressMapper;

    @Override
    public Long save(ShippingAddressSaveCmd saveCommand) {
        return commandBus.execute(saveCommand, Long.class);
    }

    @Override
    public PageData<AppShippingAddressListDTO> queryAppPage(AppShippingAddressQuery query) {
        // 只能看到当前登录用户的地址
        query.setUserId(0L);

        Page<Object> page = new Page<>(query.getPage(), query.getSize());
        IPage<AppShippingAddressListDTO> pageResult = shippingAddressMapper.queryAppPage(page, query);

        return new PageData<>(pageResult);
    }

}
