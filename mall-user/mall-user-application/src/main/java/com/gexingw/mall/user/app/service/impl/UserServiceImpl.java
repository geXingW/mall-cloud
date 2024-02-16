package com.gexingw.mall.user.app.service.impl;

import com.gexingw.mall.user.app.executor.user.AppUserQueryExecutor;
import com.gexingw.mall.user.app.executor.user.WebUserQueryExecutor;
import com.gexingw.mall.user.app.service.UserServiceI;
import com.gexingw.mall.user.app.vo.user.AppUserVO;
import com.gexingw.mall.user.app.vo.user.WebUserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/14 22:41
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class UserServiceImpl implements UserServiceI {

    private final AppUserQueryExecutor appUserQueryExecutor;
    private final WebUserQueryExecutor webUserQueryExecutor;

    @Override
    public AppUserVO getAppUserById(Long id) {
        return appUserQueryExecutor.getAppUserById(id);
    }

    @Override
    public WebUserVO getWebUserById(Long id) {
        return webUserQueryExecutor.getById(id);
    }

}
