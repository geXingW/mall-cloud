package com.gexingw.mall.product.infrastructure.gateway;

import com.gexingw.mall.product.domain.gateway.ProductGateway;
import com.gexingw.mall.product.domain.model.Product;
import com.gexingw.mall.product.infrastructure.convert.ProductConvert;
import com.gexingw.mall.product.infrastructure.gateway.db.ProductMapper;
import com.gexingw.mall.product.infrastructure.po.ProductPO;
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
    public Product find(Long id) {
        return productConvert.toDomain(productMapper.selectById(id));
    }

    @Override
    public Boolean insert(Product product) {
        ProductPO productPO = productConvert.toPO(product);
        productMapper.insert(productPO);

        product.setId(productPO.getId());

        return true;
    }

    @Override
    public Boolean update(Product product) {
        ProductPO productPO = productConvert.toPO(product);

        return productMapper.updateById(productPO) > 0;
    }

    @Override
    public Boolean delete(Product product) {
        return productMapper.deleteById(product.getId()) > 0;
    }


}
