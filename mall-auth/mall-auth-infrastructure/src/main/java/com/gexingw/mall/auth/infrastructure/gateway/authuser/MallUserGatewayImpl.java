package com.gexingw.mall.auth.infrastructure.gateway.authuser;

import com.gexingw.mall.auth.domain.gateway.MallUserGateway;
import com.gexingw.mall.auth.domain.model.MallUser;
import com.gexingw.mall.auth.infrastructure.convert.MallUserConvert;
import com.gexingw.mall.auth.infrastructure.gateway.authuser.db.MallUserMapper;
import com.gexingw.mall.auth.infrastructure.po.MallUserPO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/17 17:31
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class MallUserGatewayImpl implements MallUserGateway {

    private final MallUserMapper mallUserMapper;

    private final MallUserConvert mallUserConvert;

    @Override
    public MallUser selectById(Long id) {
        MallUserPO mallUserPO = mallUserMapper.selectById(id);

        return mallUserConvert.toDomain(mallUserPO);
    }

    @Override
    public Long insert(MallUser mallUser) {
        MallUserPO mallUserPO = mallUserConvert.toPO(mallUser);
        mallUserMapper.insert(mallUserPO);

        return mallUserPO.getId();
    }

}
