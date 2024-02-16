package com.gexingw.mall.user.client.dubbo;

import com.gexingw.mall.comm.core.util.R;
import com.gexingw.mall.user.client.clientobject.address.ShippingAddressCO;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/5 18:04
 */
public interface ShippingAddressRpcService {

    R<ShippingAddressCO> getById(Long id);

}
