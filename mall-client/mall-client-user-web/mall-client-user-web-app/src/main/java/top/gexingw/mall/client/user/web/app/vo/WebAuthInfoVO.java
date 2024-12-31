package top.gexingw.mall.client.user.web.app.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class WebAuthInfoVO implements Serializable {

    private Long id;

    private String name;

}
