package com.gexingw.mall.user.domain.user.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/23 14:41
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private Long id;

    private String username;

}
