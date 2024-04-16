package com.gexingw.mall.order.infrastructure.convert.product;

import com.gexingw.mall.common.core.convert.DomainPOConvert;
import com.gexingw.mall.domain.model.product.Product;
import com.gexingw.mall.order.infrastructure.po.product.ProductPO;
import com.gexingw.mall.product.client.co.product.DubboProductInfoCO;
import com.gexingw.mall.product.client.co.product.DubboProductListCO;
import org.mapstruct.Mapper;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 16:14
 */
@Mapper(componentModel = "spring")
public interface ProductConvert extends DomainPOConvert<Product, ProductPO> {

    Product COToDO(DubboProductInfoCO dubboProductInfoCO);

    ProductPO COToPO(DubboProductInfoCO dubboProductInfoCO);

    ProductPO COToPO(DubboProductListCO dubboProductListCO);

}
