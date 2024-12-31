package com.gexingw.mall.domain.model.order;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.gexingw.mall.common.exception.BizNotFoundException;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.javers.core.metamodel.annotation.Entity;
import org.javers.core.metamodel.annotation.Id;
import top.gexingw.ddd.core.AggregateRoot;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 15:58
 */
@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class Order implements AggregateRoot<Long> {

    @Id
    private Long id;

    /**
     * 订单号
     */
    private String number;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 收货地址
     */
    private OrderShippingAddress shippingAddress;

    /**
     * 订单商品
     */
    private List<OrderItem> items = new ArrayList<>();

    /**
     * 创建人
     */
    private OrderCreator creator;

    public Order(List<OrderItem> items, OrderCreator creator, OrderShippingAddress shippingAddress) {
        this.number = LocalDateTimeUtil.format(LocalDateTime.now(), "yyyyMMddHHmmss");

        // 下单人
        this.creator = creator;

        // 订单总金额
        this.totalAmount = items.stream().map(OrderItem::getTotalAmount).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);

        // 订单商品信息
        this.items = items.stream().map(item -> item.setOrder(this)).collect(Collectors.toList());

        // 订单收货地址信息
        if (shippingAddress == null) {
            throw new BizNotFoundException("收货地址不存在！");
        }
        this.shippingAddress = shippingAddress.setOrder(this);
    }

    /**
     * 取消订单
     *
     * @return Order
     */
    public Order cancel() {
        this.status = 2;
        return this;
    }

    public Order changeShippingAddress(OrderShippingAddress shippingAddress) {
        if (shippingAddress == null) {
            throw new BizNotFoundException("收货地址不存在！");
        }
        this.shippingAddress = shippingAddress.setOrder(this);

        return this;
    }

}
