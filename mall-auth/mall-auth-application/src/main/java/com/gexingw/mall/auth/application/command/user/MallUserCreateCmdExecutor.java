package com.gexingw.mall.auth.application.command.user;

import com.gexingw.mall.auth.domain.model.MallUser;
import com.gexingw.mall.auth.domain.repository.MallUserRepository;
import com.gexingw.mall.common.core.support.ICommand;
import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 20:01
 */
@Component
@CommandHandler(MallUserCreateCmd.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class MallUserCreateCmdExecutor implements ICommandExecutor {

    private final MallUserRepository mallUserRepository;

    @Override
    public Object handleWithResult(ICommand command) {
        MallUserCreateCmd createCmd = (MallUserCreateCmd) command;

        MallUser mallUser = new MallUser(createCmd.getUsername(), createCmd.getPhone(), createCmd.getPassword());
        if (!mallUserRepository.save(mallUser)) {
            throw new RuntimeException("创建用户失败");
        }

        return mallUser.getId();
    }

}
