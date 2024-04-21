package com.gexingw.mall.product.client.command;

import com.gexingw.mall.common.core.support.ICommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/21 11:07
 */
@Data
@NoArgsConstructor
public class DecrStockCommand implements ICommand {

    private List<Item> items;

    public DecrStockCommand(List<Item> items) {
        this.items = items;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item implements Serializable {

        private Long productId;

        private Integer stock;

    }

}
