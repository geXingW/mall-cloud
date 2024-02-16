package com.gexingw.mall.user.app.vo.address;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/5 13:23
 */
@Data
@Accessors(chain = true)
public class ShippingAddressVO implements Serializable {

    private Long id;

    private String province;

    private String city;

    private String district;

    private String address;

    private String phone;

    private String name;

    private String tag;

    private String isDefault;

}
