package com.gexingw.mall.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 15:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderShippingAddress {

    private Long orderId;

    private String orderNo;

    private String recvUserName;

    private String recvUserPhone;

    private String recvProvince;

    private String recvCity;

    private String recvDistrict;

    private String recvAddress;

    public OrderShippingAddress setOrder(Order order) {
        if (ObjectUtils.anyNull(order, order.getId(), order.getNumber())) {
            throw new RuntimeException("订单信息不完整！");
        }

        this.orderId = order.getId();
        this.orderNo = order.getNumber();

        return this;
    }

}