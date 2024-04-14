package com.gexingw.mall.order.infrastructure.dto.address;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author GeXingW
 */
@Data
public class AppShippingAddressListDTO implements Serializable {

    private Long id;

    private String name;

    private String phone;

    private String province;

    private String city;

    private String district;

    private String address;

    private Long tagId;

    private Boolean isDefault;

    private Long createUser;

    private LocalDateTime createTime;

}
