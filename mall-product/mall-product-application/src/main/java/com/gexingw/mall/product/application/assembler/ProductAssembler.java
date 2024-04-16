package com.gexingw.mall.product.application.assembler;

import com.gexingw.mall.product.application.vo.product.WebProductInfoVO;
import com.gexingw.mall.product.client.co.product.DubboProductInfoCO;
import com.gexingw.mall.product.client.co.product.DubboProductListCO;
import com.gexingw.mall.product.client.query.product.DubboProductQuery;
import com.gexingw.mall.product.infrastructure.dto.ProductInfoDTO;
import com.gexingw.mall.product.infrastructure.dto.ProductListDTO;
import com.gexingw.mall.product.infrastructure.query.product.ProductQuery;
import org.mapstruct.Mapper;

/**
 * @author GeXingW
 */
@Mapper(componentModel = "spring")
public interface ProductAssembler {

    WebProductInfoVO toWebInfoVO(ProductInfoDTO productInfoDTO);

    DubboProductInfoCO DTOToDubboCO(ProductInfoDTO productInfoDTO);

    ProductQuery dubboQryToProductQry(DubboProductQuery query);

    DubboProductListCO DTOToDubboListCO(ProductListDTO productListDTO);

}
