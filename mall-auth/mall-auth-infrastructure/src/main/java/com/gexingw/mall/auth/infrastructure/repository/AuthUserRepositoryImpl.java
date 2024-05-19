package com.gexingw.mall.auth.infrastructure.repository;

import com.gexingw.mall.auth.domain.gateway.AuthUserGateway;
import com.gexingw.mall.auth.domain.model.AuthUser;
import com.gexingw.mall.auth.domain.repository.AuthUserRepository;
import com.gexingw.mall.common.core.domain.AggregationManager;
import com.gexingw.mall.common.core.support.DbRepository;
import com.gexingw.mall.common.core.support.ThreadLocalAggregationManager;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 17:59
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthUserRepositoryImpl extends DbRepository<AuthUser, Long> implements AuthUserRepository {

    private final AggregationManager<AuthUser, Long> aggregationManager = new ThreadLocalAggregationManager<>();
    private final AuthUserGateway authUserGateway;

    @Override
    protected @Nullable AuthUser select(@NotNull Long id) {
        return authUserGateway.selectById(id);
    }

    @Override
    protected @NotNull Boolean insert(@NotNull AuthUser authUser) {
        return authUserGateway.save(authUser);
    }

    @Override
    protected @NotNull Boolean update(@NotNull AuthUser authUser) {
        return null;
    }

    @Override
    protected @NotNull Boolean delete(@NotNull AuthUser authUser) {
        return null;
    }

    @Override
    protected @NotNull AggregationManager<AuthUser, Long> getAggregationManager() {
        return this.aggregationManager;
    }

}
