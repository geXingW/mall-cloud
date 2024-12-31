package com.gexingw.mall.domain.user.model;

import lombok.Data;
import lombok.experimental.Accessors;
import top.gexingw.ddd.core.AggregateRoot;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/15 13:11
 */
@Data
@Accessors(chain = true)
public class User implements AggregateRoot {

    private Long id;

    private String name;

}
