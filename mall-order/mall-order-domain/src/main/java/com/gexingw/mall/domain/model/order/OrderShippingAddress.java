package com.gexingw.mall.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.ObjectUtils;
import org.javers.core.metamodel.annotation.Id;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 15:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderShippingAddress {

    @Id
    private Long id;

    private Long orderId;

    private String orderNo;

    private String recvUserName;

    private String recvUserPhone;

    private String recvProvince;

    private String recvCity;

    private String recvDistrict;

    private String recvAddress;

    public OrderShippingAddress setOrder(Order order) {
        if (ObjectUtils.anyNull(order, order.getNumber())) {
            throw new RuntimeException("订单信息不完整！");
        }

        this.orderId = order.getId();
        this.orderNo = order.getNumber();

        return this;
    }

}
