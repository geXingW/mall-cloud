package com.gexingw.mall.order.app.command.order;

import com.gexingw.mall.common.core.support.ICommand;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/24 17:28
 */
@Data
@Accessors(chain = true)
public class AppOrderSubmitCommand implements ICommand {

    /**
     * 订单项信息
     */
    private List<AppOrderAddCommand.OrderItem> items;

    /**
     * 金额信息
     */
    private BigDecimal amount;

    /**
     * 配送信息
     */
    private AppOrderAddCommand.Shipping shipping;

    @Data
    @Accessors(chain = true)
    public static class OrderItem {

        private Long id;

        private Integer quantity;

    }

    @Data
    @Accessors(chain = true)
    public static class Shipping {

        private Long addressId;

    }


}
