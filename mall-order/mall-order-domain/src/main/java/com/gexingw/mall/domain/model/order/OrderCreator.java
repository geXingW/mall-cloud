package com.gexingw.mall.domain.model.order;

import lombok.Data;

import java.io.Serializable;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:12
 */
@Data
public class OrderCreator implements Serializable {

    private Long id;

    private String name;

}
