package com.gexingw.mall.auth.application.service.impl;

import com.gexingw.mall.auth.application.service.AuthUserCommandService;
import com.gexingw.mall.auth.client.command.user.UserRegisterCommand;
import com.gexingw.mall.auth.domain.model.AuthUser;
import com.gexingw.mall.auth.domain.repository.AuthUserRepository;
import com.gexingw.mall.auth.domain.user.AuthUserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/13 23:05
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthUserCommandServiceImpl implements AuthUserCommandService {

    private final AuthUserRepository authUserRepository;

    private final AuthUserDomainService authUserDomainService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Long register(UserRegisterCommand registerCommand) {
        AuthUser authUser = new AuthUser(registerCommand.getPhone(), passwordEncoder.encode(registerCommand.getPassword()));
        authUserRepository.save(authUser);

        return authUser.getId();
    }

}
