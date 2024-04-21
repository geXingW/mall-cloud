package com.gexingw.mall.order.app.executor.order;

import com.gexingw.mall.common.core.support.ICommand;
import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import com.gexingw.mall.domain.gateway.address.ShippingAddressGateway;
import com.gexingw.mall.domain.gateway.product.ProductGateway;
import com.gexingw.mall.domain.model.address.ShippingAddress;
import com.gexingw.mall.domain.model.order.Order;
import com.gexingw.mall.domain.model.order.OrderItem;
import com.gexingw.mall.domain.model.order.OrderShippingAddress;
import com.gexingw.mall.domain.model.product.Product;
import com.gexingw.mall.domain.repository.order.OrderRepository;
import com.gexingw.mall.order.app.assembler.OrderItemAssembler;
import com.gexingw.mall.order.app.assembler.OrderShippingAddressAssembler;
import com.gexingw.mall.order.app.command.order.AppOrderAddCommand;
import com.gexingw.mall.order.app.command.order.AppOrderSubmitCommand;
import com.gexingw.mall.order.infrastructure.gateway.order.rpc.ProductRpcMapper;
import com.gexingw.mall.product.client.command.DecrStockCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * mall-user-service
 * App端订单提交命令 {@link AppOrderSubmitCommand} 处理器
 *
 * @author GeXingW
 * @date 2024/2/24 21:28
 */
@CommandHandler(AppOrderSubmitCommand.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AppOrderSubmitCommandExecutor implements ICommandExecutor {

    private final ShippingAddressGateway shippingAddressGateway;
    private final ProductGateway productGateway;

    private final OrderItemAssembler orderItemAssembler;
    private final OrderShippingAddressAssembler orderShippingAddressAssembler;

    private final OrderRepository orderRepository;

    private final ProductRpcMapper productRpcMapper;

    @Override
    public Long handleWithResult(ICommand command) {
        AppOrderSubmitCommand submitCommand = (AppOrderSubmitCommand) command;

        // 查询发货信息
        ShippingAddress shippingAddress = shippingAddressGateway.find(submitCommand.getShipping().getAddressId());
        if (shippingAddress == null) {
            throw new BizNotFoundException("收货地址不存在！");
        }

        // 查询商品信息
        Map<Long, Product> productMap = queryProducts(submitCommand);

        List<AppOrderAddCommand.OrderItem> commandItems = submitCommand.getItems();
        List<OrderItem> orderItems = new ArrayList<>(commandItems.size());
        List<DecrStockCommand.Item> items = new ArrayList<>(commandItems.size());

        for (AppOrderAddCommand.OrderItem item : commandItems) {
            Product product = productMap.get(item.getId());
            if (product == null) {
                throw new BizNotFoundException("商品不存在！");
            }

            orderItems.add(new OrderItem(product).setQuantity(item.getQuantity()));

            items.add(new DecrStockCommand.Item(item.getId(), item.getQuantity()));
        }

        // 批量扣减库存
        if (!productRpcMapper.decrStock(new DecrStockCommand(items))) {
            throw new RuntimeException("库存扣减失败！");
        }

        OrderShippingAddress orderShippingAddress = orderShippingAddressAssembler.fromShippingAddress(shippingAddress);

        // 构造订单商品信息
        Order order = new Order(orderItems, null, orderShippingAddress);
        orderRepository.save(order);

        return order.getId();
    }

    private Map<Long, Product> queryProducts(AppOrderSubmitCommand submitCommand) {
        Set<Long> productIds = submitCommand.getItems().stream().map(AppOrderAddCommand.OrderItem::getId).collect(Collectors.toSet());

        return productGateway.queryByIds(productIds).stream().collect(Collectors.toMap(Product::getId, o -> o, (k1, k2) -> k2));
    }

}
