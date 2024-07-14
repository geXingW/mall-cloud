package com.gexingw.mall.user.infra.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.common.core.domain.AggregationManager;
import com.gexingw.mall.common.core.support.ThreadLocalAggregationManager;
import com.gexingw.mall.common.db.support.MyBatisRepository;
import com.gexingw.mall.user.domain.user.User;
import com.gexingw.mall.user.domain.user.UserRepository;
import com.gexingw.mall.user.infra.convert.UserConvert;
import com.gexingw.mall.user.infra.mapper.UserMapper;
import com.gexingw.mall.user.infra.po.UserPO;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/4 12:51
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class UserRepositoryImpl extends MyBatisRepository<User, Long, UserMapper, UserPO> implements UserRepository {

    protected AggregationManager<User, Long> aggregationManager = new ThreadLocalAggregationManager<>();

    @Override
    public @NotNull AggregationManager<User, Long> getAggregationManager() {
        return this.aggregationManager;
    }

    @Override
    public @Nullable User find(@NotNull Long id) {
        return aggregationManager.get(id);
    }

    @Override
    public @NotNull Boolean remove(@NotNull User user) {
        aggregationManager.remove(user.getId());
        return true;
    }

    @Override
    public @NotNull Boolean save(@NotNull User user) {
        UserPO userPO = UserConvert.INSTANCE.toPO(user);
        this.baseMapper.insert(userPO);

        user.setId(userPO.getId());
        aggregationManager.set(user);

        return true;
    }

    @Override
    public User findByPhone(String phone) {
        UserPO userPO = baseMapper.selectOne(new LambdaQueryWrapper<UserPO>().eq(UserPO::getPhone, phone));

        return UserConvert.INSTANCE.toDomain(userPO);
    }

}
