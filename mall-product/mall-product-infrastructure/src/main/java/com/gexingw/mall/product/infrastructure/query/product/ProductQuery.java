package com.gexingw.mall.product.infrastructure.query.product;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/4/14 16:46
 */
@Data
public class ProductQuery implements Serializable {

    Set<Long> ids;

}
