package com.gexingw.mall.domain.order.model;

import com.gexingw.mall.comm.core.domain.Entity;
import lombok.Data;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/15 13:21
 */
@Data
public class OrderOperator implements Entity {

    private Long id;

    private String name;

}
