package com.gexingw.mall.product.application.assembler;

import com.gexingw.mall.product.application.vo.product.WebProductInfoVO;
import com.gexingw.mall.product.infrastructure.dto.WebProductInfoDTO;
import org.mapstruct.Mapper;

/**
 * @author GeXingW
 */
@Mapper(componentModel = "spring")
public interface ProductAssembler {

    WebProductInfoVO toWebInfoVO(WebProductInfoDTO productInfoDTO);

}
