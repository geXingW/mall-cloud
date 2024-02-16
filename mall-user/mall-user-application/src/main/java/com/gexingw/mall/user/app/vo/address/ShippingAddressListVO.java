package com.gexingw.mall.user.app.vo.address;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/8 15:20
 */
@Data
public class ShippingAddressListVO implements Serializable {

    private Long id;

    private String name;

    private String phone;

    private String province;

    private String city;

    private String district;

    private LocalDateTime createTime;
}
