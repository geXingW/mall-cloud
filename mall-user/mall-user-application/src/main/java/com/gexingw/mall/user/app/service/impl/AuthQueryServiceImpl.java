package com.gexingw.mall.user.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.auth.client.co.AuthInfoCO;
import com.gexingw.mall.auth.client.dubbo.AuthDubboService;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.db.support.MyBatisPlusService;
import com.gexingw.mall.common.security.support.AuthInfo;
import com.gexingw.mall.common.security.support.AuthUtil;
import com.gexingw.mall.user.app.assembler.AuthAssembler;
import com.gexingw.mall.user.app.service.AuthQueryService;
import com.gexingw.mall.user.app.vo.web.mall.auth.WebMallAuthInfoVO;
import com.gexingw.mall.user.infra.dao.user.mapper.UserMapper;
import com.gexingw.mall.user.infra.dao.user.po.UserPO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/4 18:09
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthQueryServiceImpl extends MyBatisPlusService<UserMapper, UserPO> implements AuthQueryService {

    private final AuthAssembler authAssembler;

    private final UserMapper userMapper;

    private final AuthDubboService authDubboService;

    @Override
    public WebMallAuthInfoVO queryWebUserInfo() {

        R<AuthInfoCO> respInfo = authDubboService.info();
        if (!respInfo.isSuccess()) {
            throw new RuntimeException("请先登录！");
        }

        Optional<AuthInfo> authInfo = AuthUtil.getAuthInfo();
        if (!authInfo.isPresent()) {
            return null;
        }

        LambdaQueryWrapper<UserPO> userQryWrp = new LambdaQueryWrapper<UserPO>().eq(UserPO::getAuthUserId, authInfo.get().getId());
        UserPO userPO = userMapper.selectOne(userQryWrp);
        if (userPO == null) {
            throw new RuntimeException("用户信息不存在！");
        }

        return authAssembler.toWebMallInfoVO(userPO);
    }

}
