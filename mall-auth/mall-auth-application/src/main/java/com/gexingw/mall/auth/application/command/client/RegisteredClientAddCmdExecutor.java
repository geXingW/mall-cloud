package com.gexingw.mall.auth.application.command.client;

import com.gexingw.mall.auth.domain.model.RegisteredClient;
import com.gexingw.mall.auth.domain.repository.RegisteredClientRepository;
import com.gexingw.mall.common.core.support.ICommand;
import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 22:58
 */
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@CommandHandler(RegisteredClientAddCmd.class)
public class RegisteredClientAddCmdExecutor implements ICommandExecutor {

    private final RegisteredClientRepository registeredClientRepository;

    @Override
    public Long handleWithResult(ICommand command) {
        RegisteredClientAddCmd addCmd = (RegisteredClientAddCmd) command;

        RegisteredClient registeredClient = new RegisteredClient(addCmd.getName(), addCmd.getScopes());
        registeredClientRepository.save(registeredClient);

        return registeredClient.getId();
    }

}
