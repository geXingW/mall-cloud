package com.gexingw.mall.product.application.service;

import com.gexingw.mall.product.application.vo.product.WebProductInfoVO;
import com.gexingw.mall.product.client.co.product.DubboProductInfoCO;
import com.gexingw.mall.product.client.co.product.DubboProductListCO;
import com.gexingw.mall.product.client.command.DecrStockCommand;
import com.gexingw.mall.product.client.query.product.DubboProductQuery;

import java.util.List;

/**
 * @author GeXingW
 */
public interface ProductService {

    WebProductInfoVO webInfo(Long id);

    DubboProductInfoCO dubboInfo(Long id);

    List<DubboProductListCO> queryDubboList(DubboProductQuery query);

    Boolean decrStock(Long productId, Integer quantity);

    Boolean decrStock(DecrStockCommand decrStockCommand);

}
