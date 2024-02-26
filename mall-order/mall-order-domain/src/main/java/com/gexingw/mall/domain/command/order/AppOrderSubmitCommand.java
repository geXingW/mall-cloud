package com.gexingw.mall.domain.command.order;

import com.gexingw.mall.common.core.command.ICommand;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/24 17:28
 */
@Data
@Accessors(chain = true)
public class AppOrderSubmitCommand implements ICommand {

    private Long id;

}
