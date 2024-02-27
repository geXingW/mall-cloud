package com.gexingw.mall.order.app.dto.order;

import com.gexingw.mall.common.core.command.ICommand;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 18:25
 */
@Data
@NoArgsConstructor
public class AppOrderDeleteCommand implements ICommand {

    private Long id;

    public AppOrderDeleteCommand(Long id) {
        this.id = id;
    }

}
