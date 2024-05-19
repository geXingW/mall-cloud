package com.gexingw.mall.auth.application.command.user;

import com.gexingw.mall.auth.domain.model.AuthUser;
import com.gexingw.mall.auth.domain.repository.AuthUserRepository;
import com.gexingw.mall.common.core.support.ICommand;
import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 22:21
 */
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@CommandHandler(AuthUserAddCmd.class)
public class GroupUserCreateCmdExecutor implements ICommandExecutor {

    private final AuthUserRepository authUserRepository;

    @Override
    public Long handleWithResult(ICommand command) {
        AuthUserAddCmd cmd = (AuthUserAddCmd) command;

        AuthUser authUser = new AuthUser(cmd.getPhone(), cmd.getPassword(), cmd.getUserType());
        authUserRepository.save(authUser);

        return authUser.getId();
    }

}
