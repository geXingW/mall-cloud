package com.gexingw.mall.common.core.repository;

import com.gexingw.mall.common.core.domain.AggregationRoot;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/20 21:41
 */
public interface Repository<T extends AggregationRoot> {

    T find(Long id);

    Boolean save(T aggregate);

    Boolean remove(T aggregate);

}
