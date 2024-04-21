package com.gexingw.mall.order.app.command.order;

import com.gexingw.mall.common.core.support.ICommand;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 18:24
 */
@Data
@NoArgsConstructor
public class AppOrderCancelCommand implements ICommand {

    private Long id;

    public AppOrderCancelCommand(Long id) {
        this.id = id;
    }

}
