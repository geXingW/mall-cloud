package com.gexingw.mall.user.client.clientobject.address;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/5 18:05
 */
@Data
@Accessors(chain = true)
public class ShippingAddressCO implements Serializable {

    private Long id;

    private String name;

    private String province;

    private String address;

}
