package com.gexingw.mall.user.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gexingw.mall.user.app.service.UserQueryService;
import com.gexingw.mall.user.app.vo.user.AppUserVO;
import com.gexingw.mall.user.app.vo.user.WebUserVO;
import com.gexingw.mall.user.infra.dao.user.mapper.UserMapper;
import com.gexingw.mall.user.infra.dao.user.po.UserPO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/26 13:16
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class UserQueryServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserQueryService {

    @Override
    public AppUserVO getAppUserById(Long id) {
        return null;
    }

    @Override
    public WebUserVO getWebUserById(Long id) {
        return null;
    }

}
