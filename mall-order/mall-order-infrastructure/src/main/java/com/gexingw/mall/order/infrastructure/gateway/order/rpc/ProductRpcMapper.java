package com.gexingw.mall.order.infrastructure.gateway.order.rpc;

import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.order.infrastructure.convert.product.ProductConvert;
import com.gexingw.mall.order.infrastructure.po.product.ProductPO;
import com.gexingw.mall.order.infrastructure.query.order.product.ProductQuery;
import com.gexingw.mall.product.client.co.product.DubboProductInfoCO;
import com.gexingw.mall.product.client.co.product.DubboProductListCO;
import com.gexingw.mall.product.client.dubbo.ProductDubboService;
import com.gexingw.mall.product.client.query.product.DubboProductQuery;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 15:49
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProductRpcMapper {

    @DubboReference
    private ProductDubboService productDubboService;

    private final ProductConvert productConvert;

    public ProductPO find(Long id) {
        R<DubboProductInfoCO> findResult = productDubboService.find(id);
        if (!findResult.isSuccess()) {
            return null;
        }

        return productConvert.COToPO(findResult.getData());
    }

    public List<ProductPO> queryList(ProductQuery productQuery) {
        DubboProductQuery query = new DubboProductQuery().setIds(productQuery.getIds());
        R<List<DubboProductListCO>> queryResult = productDubboService.queryList(query);
        if (!queryResult.isSuccess()) {
            return Collections.emptyList();
        }

        return queryResult.getData().stream().map(productConvert::COToPO).collect(Collectors.toList());
    }

}
