package com.gexingw.mall.user.app.vo.user;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 14:33
 */
@Data
@Accessors(chain = true)
public class AppUserVO implements Serializable {

    private Long id;

    private String name;

}
