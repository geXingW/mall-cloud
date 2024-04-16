package com.gexingw.mall.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Long addressId;

    private String name;

    private String phone;

    private String details;

}
