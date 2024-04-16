package com.gexingw.mall.product.infrastructure.gateway.db;

import com.gexingw.mall.common.db.mapper.BaseMapper;
import com.gexingw.mall.product.infrastructure.dto.ProductInfoDTO;
import com.gexingw.mall.product.infrastructure.dto.ProductListDTO;
import com.gexingw.mall.product.infrastructure.po.ProductPO;
import com.gexingw.mall.product.infrastructure.query.product.ProductQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 9:26
 */
@Mapper
public interface ProductMapper extends BaseMapper<ProductPO> {

    List<ProductListDTO> select(ProductQuery query);

    ProductInfoDTO selectInfoById(Long id);

}
