package com.gexingw.mall.product.adapter.dubbo;

import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.product.application.service.ProductService;
import com.gexingw.mall.product.client.co.product.DubboProductInfoCO;
import com.gexingw.mall.product.client.co.product.DubboProductListCO;
import com.gexingw.mall.product.client.dubbo.ProductDubboService;
import com.gexingw.mall.product.client.query.product.DubboProductQuery;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Lazy;

import java.util.List;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/15 14:13
 */
@DubboService
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class DubboProductAdapter implements ProductDubboService {

    private final ProductService productService;

    @Override
    public R<DubboProductInfoCO> find(Long id) {
        DubboProductInfoCO productInfoCO = productService.dubboInfo(id);
        if (productInfoCO == null) {
            throw new BizNotFoundException("未找到商品信息！");
        }

        return R.ok(productInfoCO);
    }

    @Override
    public R<List<DubboProductListCO>> queryList(DubboProductQuery query) {
        return R.ok(productService.queryDubboList(query));
    }

}
