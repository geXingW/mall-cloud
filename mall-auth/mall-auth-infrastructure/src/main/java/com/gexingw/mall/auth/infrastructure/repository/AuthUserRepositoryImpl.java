package com.gexingw.mall.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.auth.domain.model.AuthUser;
import com.gexingw.mall.auth.domain.repository.AuthUserRepository;
import com.gexingw.mall.auth.infrastructure.convert.AuthUserConvert;
import com.gexingw.mall.auth.infrastructure.dao.authuser.mapper.AuthUserMapper;
import com.gexingw.mall.auth.infrastructure.dao.authuser.po.AuthUserPO;
import com.gexingw.mall.common.core.support.ThreadLocalAggregationManager;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import top.gexingw.ddd.core.AggregateManager;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 17:59
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthUserRepositoryImpl implements AuthUserRepository {

    private final AggregateManager<AuthUser, Long> aggregationManager = new ThreadLocalAggregationManager<>();

    private final AuthUserMapper authUserMapper;

    private final AuthUserConvert authUserConvert;

    @Override
    public @NotNull AggregateManager<AuthUser, Long> getAggregationManager() {
        return aggregationManager;
    }

    @Override
    public AuthUser findByUsername(String username) {
        LambdaQueryWrapper<AuthUserPO> queryWrapper = new LambdaQueryWrapper<AuthUserPO>().eq(AuthUserPO::getUsername, username);
        AuthUserPO authUserPO = authUserMapper.selectOne(queryWrapper);

        return authUserConvert.toDomain(authUserPO);
    }

    @Override
    public @Nullable AuthUser find(@NotNull Long id) {
        AuthUser authUser = aggregationManager.get(id);
        if (authUser != null) {
            return authUser;
        }

        // 从数据库中查询
        AuthUserPO authUserPO = authUserMapper.selectById(id);
        if (authUserPO == null) {
            return null;
        }

        // 从数据库中查询
        authUser = authUserConvert.toDomain(authUserPO);
        aggregationManager.set(authUser);

        return authUser;
    }

    @Override
    public @NotNull Boolean remove(@NotNull AuthUser aggregationRoot) {
        // 从数据库删除
        authUserMapper.deleteById(aggregationRoot.getId());
        aggregationManager.remove(aggregationRoot.getId());

        return true;
    }

    @Override
    public @NotNull Boolean save(@NotNull AuthUser authUser) {
        AuthUserPO authUserPO = authUserConvert.toPO(authUser);
        authUserMapper.insert(authUserPO);

        authUser.setId(authUserPO.getId());
        aggregationManager.set(authUser);

        return true;
    }

}
