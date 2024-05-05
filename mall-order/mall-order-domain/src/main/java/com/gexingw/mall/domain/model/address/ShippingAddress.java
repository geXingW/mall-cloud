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

    private String recvUserName;

    private String recvUserPhone;

    private String recvProvince;

    private String recvCity;

    private String recvDistrict;

    private String recvAddress;

    private Long tagId;

    private Boolean isDefault;

}
