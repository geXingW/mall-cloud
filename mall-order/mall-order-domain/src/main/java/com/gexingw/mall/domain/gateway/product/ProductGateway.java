package com.gexingw.mall.domain.gateway.product;

import com.gexingw.mall.domain.model.product.Product;

import java.util.List;
import java.util.Set;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 16:19
 */
public interface ProductGateway {

    Product find(Long id);

    List<Product> queryByIds(Set<Long> ids);
}
