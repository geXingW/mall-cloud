package top.gexingw.mall.service.user.client.query.mall.user;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/18 14:41
 */
@Data
@Accessors(chain = true)
public class ClientMallUserQuery implements Serializable {

    private String phone;

}
