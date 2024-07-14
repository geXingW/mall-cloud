package com.gexingw.mall.domain.model.order;

import com.gexingw.mall.common.core.support.Identifier;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/10 13:13
 */
public class OrderId implements Identifier {

    private final Long value;

    public OrderId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return this.value;
    }

}
