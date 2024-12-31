package top.gexingw.mall.client.user.web.app.service;

import top.gexingw.mall.client.user.web.app.web.auth.command.WebAuthPasswdLoginCommand;
import top.gexingw.mall.client.user.web.app.vo.WebAuthTokenVO;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/13 15:36
 */
public interface AuthCommandService {

    WebAuthTokenVO login(WebAuthPasswdLoginCommand passwdLoginCommand);

}
