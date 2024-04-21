package com.gexingw.mall.product.client.dubbo;

import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.product.client.co.product.DubboProductInfoCO;
import com.gexingw.mall.product.client.co.product.DubboProductListCO;
import com.gexingw.mall.product.client.command.DecrStockCommand;
import com.gexingw.mall.product.client.query.product.DubboProductQuery;

import java.util.List;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 8:11
 */
@SuppressWarnings("unused")
public interface ProductDubboService {

    R<DubboProductInfoCO> find(Long id);

    R<List<DubboProductListCO>> queryList(DubboProductQuery query);

    R<Boolean> decrStock(Long productId, Integer quantity);

    R<Boolean> decrStock(DecrStockCommand decrStockCommand);

}
