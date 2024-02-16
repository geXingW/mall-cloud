package com.gexingw.mall.user.app.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/4 22:26
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class WebUserVO implements Serializable {

    private Long id;

    private String username;

}
