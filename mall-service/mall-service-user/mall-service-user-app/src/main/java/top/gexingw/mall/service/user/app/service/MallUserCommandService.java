package top.gexingw.mall.service.user.app.service;

import top.gexingw.mall.service.user.client.co.mall.user.MallUserAuthTokenCO;
import top.gexingw.mall.service.user.client.command.mall.user.ClientMallUserCreateCommand;
import top.gexingw.mall.service.user.domain.mall.auth.AuthToken;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/19 16:31
 */
public interface MallUserCommandService {

    Long create(ClientMallUserCreateCommand command);

    MallUserAuthTokenCO login(String phone, String password);

}
