package com.gexingw.mall.domain.model.order;

import com.gexingw.mall.common.core.domain.Entity;
import com.gexingw.mall.common.core.support.ValueObject;
import lombok.Data;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/15 13:21
 */
@Data
@ValueObject
public class OrderOperator implements Entity {

    private Long id;

    private String name;

}
