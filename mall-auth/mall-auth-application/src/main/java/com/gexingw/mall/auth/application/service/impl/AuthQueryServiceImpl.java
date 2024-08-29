package com.gexingw.mall.auth.application.service.impl;

import com.gexingw.mall.auth.application.service.AuthQueryService;
import com.gexingw.mall.auth.infrastructure.dao.authuser.mapper.AuthUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/29 14:46
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthQueryServiceImpl implements AuthQueryService {

    private final AuthUserMapper authUserMapper;

}
