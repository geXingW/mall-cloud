package top.gexingw.mall.client.user.web.app.web.auth.command;

import lombok.Data;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/7 14:54
 */
@Data
public class WebAuthPasswdLoginCommand implements Serializable {

    private String phone;

    private String password;

}
