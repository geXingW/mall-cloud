package com.gexingw.mall.order.infrastructure.query.order.product;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 18:38
 */
@Data
@Accessors(chain = true)
public class ProductQuery implements Serializable {

    private Set<Long> ids;

}
