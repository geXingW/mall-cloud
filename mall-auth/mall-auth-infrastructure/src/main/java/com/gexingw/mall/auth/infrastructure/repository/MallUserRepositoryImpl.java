package com.gexingw.mall.auth.infrastructure.repository;

import com.gexingw.mall.auth.domain.gateway.MallUserGateway;
import com.gexingw.mall.auth.domain.model.MallUser;
import com.gexingw.mall.auth.domain.repository.MallUserRepository;
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
 * @date 2024/5/17 17:27
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class MallUserRepositoryImpl extends DbRepository<MallUser, Long> implements MallUserRepository {

    private final MallUserGateway mallUserGateway;

    protected AggregationManager<MallUser, Long> aggregationManager = new ThreadLocalAggregationManager<>();

    @Override
    protected @Nullable MallUser select(@NotNull Long id) {
        return mallUserGateway.selectById(id);
    }

    @Override
    protected @NotNull Boolean insert(@NotNull MallUser mallUser) {
        Long mallUserId = mallUserGateway.insert(mallUser);
        mallUser.setId(mallUserId);

        return true;
    }

    @Override
    protected @NotNull Boolean update(@NotNull MallUser mallUser) {
        return null;
    }

    @Override
    protected @NotNull Boolean delete(@NotNull MallUser mallUser) {
        return null;
    }

    @Override
    protected @NotNull AggregationManager<MallUser, Long> getAggregationManager() {
        return this.aggregationManager;
    }

}
