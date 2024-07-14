package com.gexingw.mall.auth.application.service.impl;

import com.gexingw.mall.auth.application.service.AuthUserQueryService;
import com.gexingw.mall.auth.infrastructure.gateway.authuser.db.AuthUserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/13 23:39
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthUserQueryServiceImpl implements AuthUserQueryService {

    private final AuthUserDAO authUserDAO;

}
