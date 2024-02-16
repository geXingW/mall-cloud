package com.gexingw.mall.user.domain.address.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/11 20:48
 */
@Data
public class ShippingAddressListQuery implements Serializable {

    private Long id;

    private List<Long> ids;

    private String name;

}
