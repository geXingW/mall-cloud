package com.gexingw.mall.auth.client.co;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/29 14:48
 */
@Data
@Accessors(chain = true)
public class AuthInfoCO implements Serializable {

    private Long id;

    private String name;

}
