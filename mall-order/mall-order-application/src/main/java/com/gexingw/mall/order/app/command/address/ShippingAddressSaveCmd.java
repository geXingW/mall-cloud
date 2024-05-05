package com.gexingw.mall.order.app.command.address;

import com.gexingw.mall.common.core.support.ICommand;
import lombok.Data;

/**
 * @author GeXingW
 */
@Data
public class ShippingAddressSaveCmd implements ICommand {

    /**
     * 收货人
     */
    private String recvUserName;

    /**
     * 电话
     */
    private String recvUserPhone;

    /**
     * 省
     */
    private String recvProvince;

    /**
     * 市
     */
    private String recvCity;

    /**
     * 区/县
     */
    private String recvDistrict;

    /**
     * 详细地址
     */
    private String recvAddress;

    /**
     * 是否默认
     */
    private Boolean isDefault;

}
