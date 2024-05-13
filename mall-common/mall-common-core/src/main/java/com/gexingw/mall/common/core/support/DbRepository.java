package com.gexingw.mall.common.core.support;

import com.gexingw.mall.common.core.domain.AggregationManager;
import com.gexingw.mall.common.core.domain.AggregationRoot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/10 13:34
 */
public abstract class DbRepository<T extends AggregationRoot<ID>, ID extends Serializable> implements Repository<T, ID> {

//    protected AggregationManager<T, ID> aggregationManager;

//    /**
//     * 默认使用ThreadLocalAggregationManager缓存聚合根
//     * 子类可重写
//     *
//     * @return AggregationManager
//     */
//    @NotNull
//    protected AggregationManager<T, ID> getAggregationManager() {
//        return new ThreadLocalAggregationManager<>();
//    }

    @Nullable
    @Override
    public T find(@NotNull ID id) {
        // 从AggregationManager中查询
        T aggregationRoot = this.getAggregationManager().get(id);
        if (aggregationRoot != null) {
            return aggregationRoot;
        }

        // 查询数据库
        aggregationRoot = this.select(id);
        if (aggregationRoot == null) {
            return null;
        }

        // 存入aggregationManger
        this.getAggregationManager().set(aggregationRoot);

        return aggregationRoot;
    }

    @NotNull
    @Override
    public Boolean save(@NotNull T aggregationRoot) {
        // 没有Id走新增
        if (aggregationRoot.getId() == null) {
            if (!this.insert(aggregationRoot)) {
                return false;
            }

            this.getAggregationManager().set(aggregationRoot);
            return true;
        }

        // 有Id走更新
        if (!this.update(aggregationRoot)) {
            return false;
        }
        this.getAggregationManager().set(aggregationRoot);

        return true;
    }

    @NotNull
    @Override
    public Boolean remove(@NotNull T aggregationRoot) {
        return this.delete(aggregationRoot);
    }


    @Nullable
    protected abstract T select(@NotNull ID id);

    @NotNull
    protected abstract Boolean insert(@NotNull T aggregationRoot);

    @NotNull
    protected abstract Boolean update(@NotNull T aggregationRoot);

    @NotNull
    protected abstract Boolean delete(@NotNull T aggregationRoot);

    @NotNull
    protected abstract AggregationManager<T, ID> getAggregationManager();

}
