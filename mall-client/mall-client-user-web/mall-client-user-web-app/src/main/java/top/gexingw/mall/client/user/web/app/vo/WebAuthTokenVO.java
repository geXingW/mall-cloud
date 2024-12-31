package top.gexingw.mall.client.user.web.app.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/13 15:39
 */
@Data
public class WebAuthTokenVO implements Serializable {

    private String accessToken;

    private String refreshToken;

    private String tokenType;

    private String scope;

    private Long expiresIn;

}
