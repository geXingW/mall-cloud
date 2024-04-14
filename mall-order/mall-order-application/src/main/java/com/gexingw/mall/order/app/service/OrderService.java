package com.gexingw.mall.order.app.service;

import com.gexingw.mall.common.db.support.Pager;
import com.gexingw.mall.order.app.vo.order.AppOrderListVO;
import com.gexingw.mall.order.infrastructure.query.order.AppOrderQuery;

/**
 * @author GeXingW
 */
public interface OrderService {

    Pager<AppOrderListVO> queryAppPage(AppOrderQuery query);

}
