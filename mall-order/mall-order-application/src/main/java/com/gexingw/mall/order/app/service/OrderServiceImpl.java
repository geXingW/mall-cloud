package com.gexingw.mall.order.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gexingw.mall.common.db.support.PageData;
import com.gexingw.mall.order.app.assembler.OrderAssembler;
import com.gexingw.mall.order.app.vo.order.AppOrderListVO;
import com.gexingw.mall.order.infra.gateway.OrderGateway;
import com.gexingw.mall.order.infra.po.OrderPO;
import com.gexingw.mall.order.infra.query.order.AppOrderQuery;
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
public class OrderServiceImpl implements OrderService {

    private final OrderGateway orderGateway;

    private final OrderAssembler orderAssembler;

    @Override
    public PageData<AppOrderListVO> queryAppPage(AppOrderQuery query) {
        IPage<OrderPO> orderPoPageResult = orderGateway.queryAppList(query);
        if (orderPoPageResult.getTotal() == 0) {
            return new PageData<>();
        }
        List<AppOrderListVO> records = orderPoPageResult.getRecords().stream().map(orderAssembler::toAppListVO).collect(Collectors.toList());

        return new PageData<AppOrderListVO>(orderPoPageResult).setRecords(records);
    }

}
