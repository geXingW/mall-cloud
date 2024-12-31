package top.gexingw.mall.client.user.web.infra.rpc.user.mall.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/18 14:39
 */
@Getter
@Setter
@Accessors(chain = true)
public class MallUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String phone;

}
