package com.gexingw.mall.product.application.service.impl;

import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.product.application.assembler.ProductAssembler;
import com.gexingw.mall.product.application.service.ProductService;
import com.gexingw.mall.product.application.vo.product.WebProductInfoVO;
import com.gexingw.mall.product.client.co.product.DubboProductInfoCO;
import com.gexingw.mall.product.client.co.product.DubboProductListCO;
import com.gexingw.mall.product.client.query.product.DubboProductQuery;
import com.gexingw.mall.product.infrastructure.dto.ProductInfoDTO;
import com.gexingw.mall.product.infrastructure.dto.ProductListDTO;
import com.gexingw.mall.product.infrastructure.gateway.db.ProductMapper;
import com.gexingw.mall.product.infrastructure.query.product.ProductQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GeXingW
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final ProductAssembler productAssembler;

    @Override
    public WebProductInfoVO webInfo(Long id) {
        ProductInfoDTO productInfoDTO = productMapper.selectInfoById(id);

        return productAssembler.toWebInfoVO(productInfoDTO);
    }

    @Override
    public DubboProductInfoCO dubboInfo(Long id) {
        ProductInfoDTO productInfoDTO = productMapper.selectInfoById(id);
        if (productInfoDTO == null) {
            throw new BizNotFoundException("商品不存在!");
        }

        return productAssembler.DTOToDubboCO(productInfoDTO);
    }

    @Override
    public List<DubboProductListCO> queryDubboList(DubboProductQuery query) {
        ProductQuery productQuery = productAssembler.dubboQryToProductQry(query);
        List<ProductListDTO> select = productMapper.select(productQuery);

        return select.stream().map(productAssembler::DTOToDubboListCO).collect(Collectors.toList());
    }

}
