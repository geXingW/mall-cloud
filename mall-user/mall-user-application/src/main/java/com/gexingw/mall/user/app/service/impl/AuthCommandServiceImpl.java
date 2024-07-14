package com.gexingw.mall.user.app.service.impl;

import com.gexingw.mall.user.app.assembler.MallAuthAssembler;
import com.gexingw.mall.user.app.command.auth.AppAuthLoginCommand;
import com.gexingw.mall.user.app.command.auth.AppAuthRegisterCommand;
import com.gexingw.mall.user.app.service.AuthCommandService;
import com.gexingw.mall.user.app.vo.mall.AppAuthLoginVO;
import com.gexingw.mall.user.domain.auth.AuthToken;
import com.gexingw.mall.user.domain.auth.AuthUserRepository;
import com.gexingw.mall.user.domain.user.UserDomainService;
import com.gexingw.mall.user.domain.user.UserRepository;
import com.gexingw.mall.user.infra.config.AuthClientConfig;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/4 18:08
 */
@Service
@DubboService
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthCommandServiceImpl implements AuthCommandService {

    private final AuthClientConfig authClientConfig;

    private final MallAuthAssembler mallAuthAssembler;

    private final AuthUserRepository authUserRepository;
    private final UserRepository userRepository;

    private final AuthCommandService authCommandService;

    private final UserDomainService userDomainService;

    @Override
    public AppAuthLoginVO login(AppAuthLoginCommand loginCmd) {
        AuthToken authToken = userDomainService.login(loginCmd.getPhone(), loginCmd.getPassword());

        return mallAuthAssembler.toAppLoginVO(authToken);
    }

    @Override
    public void register(AppAuthRegisterCommand registerCommand) {

    }

    @Override
    public void logout(AppAuthLoginCommand loginCmd) {

    }

}
