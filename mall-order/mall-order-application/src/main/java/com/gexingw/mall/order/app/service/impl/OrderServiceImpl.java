package com.gexingw.mall.order.app.service.impl;

import com.gexingw.mall.common.db.support.Pager;
import com.gexingw.mall.domain.gateway.OrderGateway;
import com.gexingw.mall.order.app.assembler.OrderAssembler;
import com.gexingw.mall.order.app.service.OrderService;
import com.gexingw.mall.order.app.vo.order.AppOrderListVO;
import com.gexingw.mall.order.infrastructure.dto.order.AppOrderListDTO;
import com.gexingw.mall.order.infrastructure.gateway.order.db.OrderMapper;
import com.gexingw.mall.order.infrastructure.query.order.AppOrderQuery;
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

    private final OrderMapper orderMapper;

    @Override
    public Pager<AppOrderListVO> queryAppPage(AppOrderQuery query) {
        Pager<AppOrderListDTO> pager = new Pager<>(query.getPage(), query.getSize());
        Pager<AppOrderListDTO> orderPoPageResult = orderMapper.queryAppList(pager, query);
        if (orderPoPageResult.getTotal() == 0) {
            return new Pager<>(query.getPage(), query.getSize());
        }
        List<AppOrderListDTO> pageRecords = orderPoPageResult.getRecords();
        List<AppOrderListVO> records = pageRecords.stream().map(orderAssembler::toAppListVO).collect(Collectors.toList());

        return Pager.of(pager.getPage(), pager.getSize(), pager.getTotal(), records);
    }

}
