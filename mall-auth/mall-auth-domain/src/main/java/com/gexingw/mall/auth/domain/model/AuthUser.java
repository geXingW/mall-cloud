package com.gexingw.mall.auth.domain.model;

import com.gexingw.mall.common.core.domain.AggregationRoot;
import lombok.Data;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 17:02
 */
@Data
public class AuthUser implements AggregationRoot {

    private Long id;

    private String username;

    private String phone;

}
