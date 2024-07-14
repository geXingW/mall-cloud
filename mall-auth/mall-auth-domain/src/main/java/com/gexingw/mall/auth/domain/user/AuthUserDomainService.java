package com.gexingw.mall.auth.domain.user;

import com.gexingw.mall.auth.domain.model.AuthUser;
import com.gexingw.mall.auth.domain.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/13 23:47
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthUserDomainService {

    private final AuthUserRepository authUserRepository;

    public Long register(AuthUser authUser) {
        return 1L;
    }

}
