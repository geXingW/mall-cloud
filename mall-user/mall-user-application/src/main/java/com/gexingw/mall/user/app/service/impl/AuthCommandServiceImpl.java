package com.gexingw.mall.user.app.service.impl;

import com.gexingw.mall.user.app.assembler.MallAuthAssembler;
import com.gexingw.mall.user.app.command.auth.AppAuthLoginCommand;
import com.gexingw.mall.user.app.command.auth.WebMallAuthLoginCommand;
import com.gexingw.mall.user.app.service.AuthCommandService;
import com.gexingw.mall.user.app.vo.mall.AppAuthLoginVO;
import com.gexingw.mall.user.app.vo.web.mall.auth.WebMallAuthTokenVO;
import com.gexingw.mall.user.domain.auth.AuthToken;
import com.gexingw.mall.user.domain.user.UserDomainService;
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

    private final MallAuthAssembler mallAuthAssembler;

    private final UserDomainService userDomainService;

    @Override
    public AppAuthLoginVO login(AppAuthLoginCommand loginCmd) {
        AuthToken authToken = userDomainService.login(loginCmd.getPhone(), loginCmd.getPassword());

        return mallAuthAssembler.toAppLoginVO(authToken);
    }

    @Override
    public void logout(AppAuthLoginCommand loginCmd) {

    }

    @Override
    public WebMallAuthTokenVO login(WebMallAuthLoginCommand loginCommand) {
        AuthToken authToken = userDomainService.login(loginCommand.getPhone(), loginCommand.getPassword());

        return mallAuthAssembler.toWebVO(authToken);
    }

    @Override
    public void logout(String accessToken) {
        userDomainService.logout(accessToken);
    }

}
