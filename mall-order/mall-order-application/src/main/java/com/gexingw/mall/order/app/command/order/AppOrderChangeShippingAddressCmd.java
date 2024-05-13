package com.gexingw.mall.order.app.command.order;

import com.gexingw.mall.common.core.support.ICommand;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/5 12:28
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class AppOrderChangeShippingAddressCmd implements ICommand {

    private Long id;

    /**
     * 新的收货地址Id
     */
    private Long shippingAddressId;

    public AppOrderChangeShippingAddressCmd(Long id, Long shippingAddressId) {
        this.id = id;
        this.shippingAddressId = shippingAddressId;
    }

}
