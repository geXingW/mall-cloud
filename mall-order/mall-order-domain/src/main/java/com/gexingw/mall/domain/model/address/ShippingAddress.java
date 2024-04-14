package com.gexingw.mall.domain.model.address;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author GeXingW
 */
@Data
@Accessors(chain = true)
public class ShippingAddress implements Serializable {

    private Long id;

    private Long userId;

    private String name;

    private String phone;

    private String province;

    private String city;

    private String district;

    private String address;

    private Long tagId;

    private Boolean isDefault;

}
