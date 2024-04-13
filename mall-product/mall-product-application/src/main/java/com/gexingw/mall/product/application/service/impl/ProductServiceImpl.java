package com.gexingw.mall.product.application.service.impl;

import com.gexingw.mall.product.application.assembler.ProductAssembler;
import com.gexingw.mall.product.application.service.ProductService;
import com.gexingw.mall.product.application.vo.product.WebProductInfoVO;
import com.gexingw.mall.product.infrastructure.dto.WebProductInfoDTO;
import com.gexingw.mall.product.infrastructure.gateway.db.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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
        WebProductInfoDTO webProductInfoDTO = productMapper.webInfo(id);

        return productAssembler.toWebInfoVO(webProductInfoDTO);
    }

}
