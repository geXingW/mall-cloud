package com.gexingw.mall.product.domain.gateway;

import com.gexingw.mall.product.domain.model.Product;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 9:10
 */
public interface ProductGateway {

    Product find(Long id);

}
