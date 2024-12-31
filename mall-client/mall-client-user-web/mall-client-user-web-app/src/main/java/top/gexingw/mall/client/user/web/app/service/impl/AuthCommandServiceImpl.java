package top.gexingw.mall.client.user.web.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import top.gexingw.mall.client.user.web.app.assembler.AuthAssembler;
import top.gexingw.mall.client.user.web.app.service.AuthCommandService;
import top.gexingw.mall.client.user.web.app.vo.WebAuthTokenVO;
import top.gexingw.mall.client.user.web.app.web.auth.command.WebAuthPasswdLoginCommand;
import top.gexingw.mall.client.user.web.infra.rpc.user.mall.user.MallUserDTO;
import top.gexingw.mall.client.user.web.infra.rpc.user.mall.user.UserMallUserClient;
import top.gexingw.mall.service.user.client.co.mall.user.MallUserAuthTokenCO;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/13 15:36
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthCommandServiceImpl implements AuthCommandService {

    private final UserMallUserClient userMallUserClient;

    private final AuthAssembler authAssembler;

    /**
     * Handles user login via password authentication. If the user does not exist, a new account is automatically created.
     *
     * @param passwdLoginCommand the command containing the user's phone number and password
     * @return a WebAuthTokenVO containing the authentication token for the user
     */
    @Override
    public WebAuthTokenVO login(WebAuthPasswdLoginCommand passwdLoginCommand) {
        // Check if the user exists
        MallUserDTO mallUser = userMallUserClient.findByPhone(passwdLoginCommand.getPhone());

        // If the user does not exist, create a new account automatically
        if (mallUser == null) {
            Long existUserId = userMallUserClient.create(passwdLoginCommand.getPhone(), passwdLoginCommand.getPassword());
            if (existUserId == null) {
                throw new RuntimeException("登录失败！");
            }
        }

        // Login the user and get the authentication token
        MallUserAuthTokenCO loginResult = userMallUserClient.login(passwdLoginCommand.getPhone(), passwdLoginCommand.getPassword());

        // Convert the authentication token to a WebAuthTokenVO
        return authAssembler.toTokenVO(loginResult);
    }

}
