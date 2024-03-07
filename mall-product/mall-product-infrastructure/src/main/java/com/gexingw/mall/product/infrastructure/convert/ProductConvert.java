package com.gexingw.mall.product.infrastructure.convert;

import com.gexingw.mall.common.core.convert.DomainDoConvert;
import com.gexingw.mall.product.domain.model.Product;
import com.gexingw.mall.product.infrastructure.po.ProductPO;
import org.mapstruct.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 9:40
 */
@Mapper(componentModel = "spring")
public interface ProductConvert extends DomainDoConvert<Product, ProductPO> {

}
