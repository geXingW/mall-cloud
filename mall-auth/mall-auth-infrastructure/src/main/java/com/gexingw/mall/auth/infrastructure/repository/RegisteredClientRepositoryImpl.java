package com.gexingw.mall.auth.infrastructure.repository;

import com.gexingw.mall.auth.domain.gateway.RegisteredClientGateway;
import com.gexingw.mall.auth.domain.model.RegisteredClient;
import com.gexingw.mall.auth.domain.repository.RegisteredClientRepository;
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
 * @date 2024/5/18 23:07
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class RegisteredClientRepositoryImpl extends DbRepository<RegisteredClient, Long> implements RegisteredClientRepository {

    private final AggregationManager<RegisteredClient, Long> aggregationManager = new ThreadLocalAggregationManager<>();
    private final RegisteredClientGateway registeredClientGateway;

    @Override
    protected @Nullable RegisteredClient select(@NotNull Long id) {
        return null;
    }

    @Override
    protected @NotNull Boolean insert(@NotNull RegisteredClient registeredClient) {
        return registeredClientGateway.insert(registeredClient);
    }

    @Override
    protected @NotNull Boolean update(@NotNull RegisteredClient registeredClient) {
        return null;
    }

    @Override
    protected @NotNull Boolean delete(@NotNull RegisteredClient registeredClient) {
        return null;
    }

    @Override
    protected @NotNull AggregationManager<RegisteredClient, Long> getAggregationManager() {
        return this.aggregationManager;
    }

}
