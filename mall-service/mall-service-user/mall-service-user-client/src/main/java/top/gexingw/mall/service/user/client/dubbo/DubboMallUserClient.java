package top.gexingw.mall.service.user.client.dubbo;

import com.gexingw.mall.common.core.util.R;
import top.gexingw.mall.service.user.client.co.mall.user.MallUserAuthTokenCO;
import top.gexingw.mall.service.user.client.co.mall.user.MallUserCO;
import top.gexingw.mall.service.user.client.command.mall.user.ClientMallUserCreateCommand;
import top.gexingw.mall.service.user.client.query.mall.user.ClientMallUserQuery;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/10/18 13:59
 */
public interface DubboMallUserClient {

    R<MallUserCO> find(ClientMallUserQuery clientMallUserQuery);

    R<Long> create(ClientMallUserCreateCommand command);

    /**
     * mall-cloud
     *
     * @param phone    phone
     * @param password password
     * @return {@link R}<{@link Object}>
     *
     * @author GeXingW
     * @date 2024/10/18 14:00
     */
    R<MallUserAuthTokenCO> login(String phone, String password);

}
