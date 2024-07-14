package com.gexingw.mall.auth.infrastructure.repository;

import com.gexingw.mall.auth.domain.model.AuthUser;
import com.gexingw.mall.auth.domain.repository.AuthUserRepository;
import com.gexingw.mall.auth.infrastructure.convert.AuthUserConvert;
import com.gexingw.mall.auth.infrastructure.gateway.authuser.db.AuthUserDAO;
import com.gexingw.mall.auth.infrastructure.po.AuthUserPO;
import com.gexingw.mall.common.core.domain.AggregationManager;
import com.gexingw.mall.common.core.support.ThreadLocalAggregationManager;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 17:59
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthUserRepositoryImpl implements AuthUserRepository {

    private final AggregationManager<AuthUser, Long> aggregationManager = new ThreadLocalAggregationManager<>();

    private final AuthUserDAO authUserDAO;

    private final AuthUserConvert authUserConvert;

    @Override
    public @NotNull AggregationManager<AuthUser, Long> getAggregationManager() {
        return aggregationManager;
    }

    @Override
    public AuthUser findByUsername(String username) {
        AuthUserPO authUserPO = authUserDAO.findByUsername(username);

        return authUserConvert.toDomain(authUserPO);
    }

    @Override
    public @Nullable AuthUser find(@NotNull Long id) {
        AuthUser authUser = aggregationManager.get(id);
        if (authUser != null) {
            return authUser;
        }

        // 从数据库中查询
        Optional<AuthUserPO> authUserPO = authUserDAO.findById(id);
        if (!authUserPO.isPresent()) {
            return null;
        }

        // 从数据库中查询
        authUser = authUserConvert.toDomain(authUserPO.get());
        aggregationManager.set(authUser);

        return authUser;
    }

    @Override
    public @NotNull Boolean remove(@NotNull AuthUser aggregationRoot) {
        // 从数据库删除
        authUserDAO.deleteById(aggregationRoot.getId());
        aggregationManager.remove(aggregationRoot.getId());

        return true;
    }

    @Override
    public @NotNull Boolean save(@NotNull AuthUser authUser) {
        AuthUserPO authUserPO = authUserConvert.toPO(authUser);
        authUserDAO.save(authUserPO);

        authUser.setId(authUserPO.getId());
        aggregationManager.set(authUser);

        return true;
    }

}
