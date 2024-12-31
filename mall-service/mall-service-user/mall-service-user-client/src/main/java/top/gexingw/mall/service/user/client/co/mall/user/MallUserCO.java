package top.gexingw.mall.service.user.client.co.mall.user;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/18 15:09
 */
@Data
@Accessors(chain = true)
public class MallUserCO implements Serializable {

    private Long id;

    private Long authUserId;

    private String username;

    private String phone;

}
