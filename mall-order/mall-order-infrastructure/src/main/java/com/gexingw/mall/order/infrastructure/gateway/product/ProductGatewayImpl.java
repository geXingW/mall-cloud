package com.gexingw.mall.order.infrastructure.gateway.product;

import com.gexingw.mall.domain.gateway.product.ProductGateway;
import com.gexingw.mall.domain.model.product.Product;
import com.gexingw.mall.order.infrastructure.convert.product.ProductConvert;
import com.gexingw.mall.order.infrastructure.gateway.order.rpc.ProductRpcMapper;
import com.gexingw.mall.order.infrastructure.po.product.ProductPO;
import com.gexingw.mall.order.infrastructure.query.order.product.ProductQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 16:18
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProductGatewayImpl implements ProductGateway {

    private final ProductRpcMapper productRpcMapper;

    private final ProductConvert productConvert;

    @Override
    public Product find(Long id) {
        return productConvert.toDomain(productRpcMapper.find(id));
    }

    @Override
    public List<Product> queryByIds(Set<Long> ids) {
        List<ProductPO> productPOS = productRpcMapper.queryList(new ProductQuery().setIds(ids));

        return productPOS.stream().map(productConvert::toDomain).collect(Collectors.toList());
    }

}
