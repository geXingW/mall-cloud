package top.gexingw.mall.service.user.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.common.db.support.MyBatisPlusService;
import com.gexingw.mall.common.exception.BizNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import top.gexingw.mall.service.user.app.service.MallUserAssembler;
import top.gexingw.mall.service.user.app.service.MallUserQueryService;
import top.gexingw.mall.service.user.client.co.mall.user.MallUserCO;
import top.gexingw.mall.service.user.client.query.mall.user.ClientMallUserQuery;
import top.gexingw.mall.service.user.dao.mall.user.MallUserMapper;
import top.gexingw.mall.service.user.dao.mall.user.MallUserPO;
import top.gexingw.mall.service.user.domain.mall.user.MallUser;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/10/18 14:07
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class MallUserQueryServiceImpl extends MyBatisPlusService<MallUserMapper, MallUserPO> implements MallUserQueryService {

    private final MallUserMapper mallUserMapper;

    private final MallUserAssembler mallUserAssembler;

    @Override
    public MallUserCO find(ClientMallUserQuery clientMallUserQuery) {
        LambdaQueryWrapper<MallUserPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(clientMallUserQuery.getPhone()), MallUserPO::getPhone, clientMallUserQuery.getPhone());
        MallUserPO mallUserPO = this.getOne(queryWrapper, false);
        if (mallUserPO == null) {
            throw new BizNotFoundException("用户不存在！");
        }

        return mallUserAssembler.toVO(mallUserPO);
    }

}
