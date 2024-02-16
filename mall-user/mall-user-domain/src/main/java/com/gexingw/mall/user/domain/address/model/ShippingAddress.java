package com.gexingw.mall.user.domain.address.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/5 13:42
 */
@Data
@Accessors(chain = true)
public class ShippingAddress {

    private Long id;

    private String province;

    private String city;

    private String district;

    private String address;

    private String phone;

    private String name;

    private Long tagId;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Boolean isDefault;

}
