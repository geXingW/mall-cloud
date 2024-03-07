package com.gexingw.mall.product.application.service.impl;

import com.gexingw.mall.common.core.enums.ProductRespCode;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.product.client.dubbo.ProductDubboService;
import com.gexingw.mall.product.domain.gateway.ProductGateway;
import com.gexingw.mall.product.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Lazy;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 8:46
 */
@DubboService
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProductDubboServiceImpl implements ProductDubboService {

    private final ProductGateway productGateway;

    @Override
    public R<Object> geyById(Long id) {
        Product product = productGateway.getById(id);
        if (product == null) {
            return R.fail(ProductRespCode.NOT_FOUNT);
        }

        return R.ok(product);
    }

}
