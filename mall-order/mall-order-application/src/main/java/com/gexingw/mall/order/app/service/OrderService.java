package com.gexingw.mall.order.app.service;

import com.gexingw.mall.common.db.support.PageData;
import com.gexingw.mall.order.app.vo.order.AppOrderListVO;
import com.gexingw.mall.order.infra.query.order.AppOrderQuery;

/**
 * @author GeXingW
 */
public interface OrderService {

    PageData<AppOrderListVO> queryAppPage(AppOrderQuery query);

}
