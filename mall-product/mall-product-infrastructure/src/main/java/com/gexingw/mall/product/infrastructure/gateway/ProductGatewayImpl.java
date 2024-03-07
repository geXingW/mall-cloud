package com.gexingw.mall.product.infrastructure.gateway;

import com.gexingw.mall.product.domain.gateway.ProductGateway;
import com.gexingw.mall.product.domain.model.Product;
import com.gexingw.mall.product.infrastructure.convert.ProductConvert;
import com.gexingw.mall.product.infrastructure.gateway.db.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 8:12
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@SuppressWarnings("unused")
public class ProductGatewayImpl implements ProductGateway {

    private final ProductMapper productMapper;

    private final ProductConvert productConvert;

    @Override
    public Product getById(Long id) {
        return productConvert.toDomain(productMapper.selectById(id));
    }

}
