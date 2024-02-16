package com.gexingw.mall.user.client.clientobject.user;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 11:45
 */
@Data
@Accessors(chain = true)
public class UserCO implements Serializable {

    private Long id;

    private String name;

    private LocalDateTime createTime;

}
