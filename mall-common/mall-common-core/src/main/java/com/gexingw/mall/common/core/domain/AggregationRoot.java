package com.gexingw.mall.common.core.domain;

import java.io.Serializable;
import java.util.List;

/**
 * mall-user-service
 * 聚合根
 *
 * @author GeXingW
 * @date 2024/2/15 13:12
 */
public interface AggregationRoot<ID extends Serializable> extends Serializable {

    ID getId();

    public default List<Object> getChanges() {
        return null;
    }

}
