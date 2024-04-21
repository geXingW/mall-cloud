package com.gexingw.mall.product.infrastructure.repository;

import com.gexingw.mall.product.domain.gateway.ProductGateway;
import com.gexingw.mall.product.domain.model.Product;
import com.gexingw.mall.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/17 13:36
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductGateway productGateway;

    @Override
    public Product find(Long id) {
        return productGateway.find(id);
    }

    @Override
    public Boolean save(Product product) {
        if (product.getId() == null || product.getId() <= 0) {
            if (!productGateway.insert(product)) {
                throw new RuntimeException("保存失败！");
            }

            return true;
        }

        if (!productGateway.update(product)) {
            throw new RuntimeException("商品更新失败！");
        }

        return true;
    }

    @Override
    public Boolean remove(Product product) {
        return productGateway.delete(product);
    }

}
