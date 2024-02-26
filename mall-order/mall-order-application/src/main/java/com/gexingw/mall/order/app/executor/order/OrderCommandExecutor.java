package com.gexingw.mall.order.app.executor.order;

import com.gexingw.mall.common.core.enums.CommonRespCode;
import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.domain.gateway.OrderGateway;
import com.gexingw.mall.domain.gateway.ShippingAddressGateway;
import com.gexingw.mall.domain.order.model.*;
import com.gexingw.mall.domain.service.OrderDomainService;
import com.gexingw.mall.domain.user.UserGateway;
import com.gexingw.mall.domain.user.model.User;
import com.gexingw.mall.order.app.assembler.OrderAssembler;
import com.gexingw.mall.order.app.assembler.OrderItemAssembler;
import com.gexingw.mall.order.app.assembler.OrderOperatorAssembler;
import com.gexingw.mall.order.app.dto.order.AppOrderAddCommand;
import com.gexingw.mall.order.app.vo.order.AppOrderDetailVO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/5 18:24
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderCommandExecutor {

    private final OrderDomainService orderDomainService;

    private final OrderAssembler orderAssembler;
    private final OrderItemAssembler orderItemAssembler;
    private final OrderOperatorAssembler orderOperatorAssembler;

    private final ShippingAddressGateway shippingAddressGateway;
    private final UserGateway userGateway;
    private final OrderGateway orderGateway;

    /**
     * 下单
     *
     * @param addCommand 下单命令
     * @return 订单Id
     */
    public Long add(AppOrderAddCommand addCommand) {
        // 配送地址
        AppOrderAddCommand.Shipping shipping = addCommand.getShipping();
        OrderShippingAddress shippingAddress = shippingAddressGateway.getById(shipping.getAddressId());
        if (shippingAddress == null) {
            throw new BizNotFoundException(CommonRespCode.NOT_FOUND, "配送地址不存在！");
        }

        // 查询操作人信息
        User user = userGateway.getById(1L);
        if (user == null) {
            throw new BizNotFoundException(CommonRespCode.NOT_FOUND, "用户信息不存在！");
        }
        //noinspection unused
        OrderOperator orderOperator = orderOperatorAssembler.toOrderOperator(user);

        // 订单商品
        List<OrderItem> orderItems = addCommand.getItems().stream().map(orderItemAssembler::toOrderItem).collect(Collectors.toList());
        // 订单
        Order order = OrderFactory.createOrder(orderItems, shippingAddress);

        return orderDomainService.save(order);
    }

    /**
     * 删除订单
     *
     * @param id 订单Id
     * @return 删除结果
     */
    public boolean delete(Long id) {
        // 检查订单是否存在
        if (!orderGateway.exist(id)) {
            throw new BizNotFoundException(CommonRespCode.NOT_FOUND, "订单不存在！");
        }

        return orderDomainService.delete(id);
    }

    /**
     * 查询订单详情
     *
     * @param id 订单Id
     * @return 订单详情
     */
    public AppOrderDetailVO getById(Long id) {
        Order order = orderDomainService.getById(id);
        if (order == null) {
            throw new BizNotFoundException(CommonRespCode.NOT_FOUND, "订单不存在！");
        }

        return orderAssembler.toAppVO(order);
    }

}
