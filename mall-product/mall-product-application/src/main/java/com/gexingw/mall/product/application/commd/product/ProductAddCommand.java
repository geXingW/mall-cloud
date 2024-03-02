package com.gexingw.mall.product.application.commd.product;

import lombok.Data;

import java.io.Serializable;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/2 8:09
 */
@Data
public class ProductAddCommand implements Serializable {

    private String name;

}
