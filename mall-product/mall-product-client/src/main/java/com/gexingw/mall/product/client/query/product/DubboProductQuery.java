package com.gexingw.mall.product.client.query.product;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 17:15
 */
@Data
@Accessors(chain = true)
public class DubboProductQuery implements Serializable {

    private Set<Long> ids;

}
