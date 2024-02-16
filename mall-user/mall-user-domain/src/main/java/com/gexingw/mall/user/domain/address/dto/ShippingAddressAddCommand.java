package com.gexingw.mall.user.domain.address.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/8 14:30
 */
@Data
public class ShippingAddressAddCommand implements Serializable {

    private String name;

    private String phone;

    private String province;

    private String city;

    private String district;

    private String address;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Boolean isDefault;

}
