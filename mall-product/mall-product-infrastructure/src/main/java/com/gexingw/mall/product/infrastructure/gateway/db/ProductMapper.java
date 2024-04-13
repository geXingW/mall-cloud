package com.gexingw.mall.product.infrastructure.gateway.db;

import com.gexingw.mall.common.db.mapper.BaseMapper;
import com.gexingw.mall.product.infrastructure.dto.WebProductInfoDTO;
import com.gexingw.mall.product.infrastructure.po.ProductPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 9:26
 */
@Mapper
public interface ProductMapper extends BaseMapper<ProductPO> {

    WebProductInfoDTO webInfo(Long id);

}
