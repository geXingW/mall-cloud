package com.gexingw.mall.product.client.dubbo;

import com.gexingw.mall.common.core.util.R;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 8:11
 */
@SuppressWarnings("unused")
public interface ProductDubboService {

    R<Object> geyById(Long id);

}
