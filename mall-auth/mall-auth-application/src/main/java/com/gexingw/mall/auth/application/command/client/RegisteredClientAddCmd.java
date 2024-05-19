package com.gexingw.mall.auth.application.command.client;

import com.gexingw.mall.common.core.support.ICommand;
import lombok.Data;

import java.util.Set;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 22:57
 */
@Data
public class RegisteredClientAddCmd implements ICommand {

    private String name;

    private Integer type;

    private Set<String> scopes;

}
