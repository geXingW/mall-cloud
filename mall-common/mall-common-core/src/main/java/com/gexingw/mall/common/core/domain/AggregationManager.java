package com.gexingw.mall.common.core.domain;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/12 10:44
 */
public interface AggregationManager<T extends AggregationRoot<ID>, ID extends Serializable> {

    /**
     * 获取聚合根
     *
     * @param id 聚合根Id
     * @return AggregationRoot
     */
    T get(ID id);

    /**
     * 保存聚合根
     *
     * @param aggregationRoot 聚合根
     * @return AggregationRoot
     */
    AggregationRoot<ID> set(T aggregationRoot);

    /**
     * 移除聚合根
     *
     * @param aggregationRoot 聚合根
     */
    void remove(T aggregationRoot);

    /**
     * 移除聚合根
     *
     * @param id id
     */
    void remove(ID id);

}
