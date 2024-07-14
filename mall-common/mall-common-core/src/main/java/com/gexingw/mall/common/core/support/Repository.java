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
 * @date 2024/5/10 13:07
 */
public interface Repository<T extends AggregationRoot<ID>, ID extends Serializable> {

    @NotNull
    AggregationManager<T, ID> getAggregationManager();

    /**
     * 查找聚合
     *
     * @param id 聚合根Id
     * @return 聚合根
     */
    @Nullable
    T find(@NotNull ID id);

    /**
     * 删除聚合
     *
     * @param aggregationRoot 聚合根
     * @return 执行结果
     */
    @NotNull
    Boolean remove(@NotNull T aggregationRoot);

    /**
     * 保存（新增或更新）聚合
     *
     * @param aggregationRoot 聚合根
     * @return 执行结果
     */
    @NotNull
    Boolean save(@NotNull T aggregationRoot);

}
