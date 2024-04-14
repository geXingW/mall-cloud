package com.gexingw.mall.order.app.service;

import com.gexingw.mall.common.db.support.PageData;
import com.gexingw.mall.order.app.command.address.ShippingAddressSaveCmd;
import com.gexingw.mall.order.infrastructure.dto.address.AppShippingAddressListDTO;
import com.gexingw.mall.order.infrastructure.query.order.AppShippingAddressQuery;

/**
 * @author GeXingW
 */
public interface ShippingAddressService {

    Long save(ShippingAddressSaveCmd saveCommand);

    PageData<AppShippingAddressListDTO> queryAppPage(AppShippingAddressQuery query);

}
