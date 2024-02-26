package com.gexingw.mall.domain.user.model;

import com.gexingw.mall.common.core.domain.Aggregation;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/15 13:11
 */
@Data
@Accessors(chain = true)
public class User implements Aggregation {

    private Long id;

    private String name;

}
