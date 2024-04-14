package com.gexingw.mall.order.app.command.address;

import com.gexingw.mall.common.spring.command.ICommand;
import lombok.Data;

/**
 * @author GeXingW
 */
@Data
public class ShippingAddressSaveCmd implements ICommand {

    /**
     * 收货人
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区/县
     */
    private String district;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 是否默认
     */
    private Boolean isDefault;

}
