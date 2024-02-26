package com.gexingw.mall.domain.command.order;

import com.gexingw.mall.common.core.command.ICommand;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 11:57
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class AppOrderCancelCommand implements ICommand {

    private Long id;

    public AppOrderCancelCommand(Long id) {
        this.id = id;
    }

}
