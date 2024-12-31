package top.gexingw.mall.service.user.app.service;

import top.gexingw.mall.service.user.client.co.mall.user.MallUserCO;
import top.gexingw.mall.service.user.client.query.mall.user.ClientMallUserQuery;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/10/18 14:07
 */
public interface MallUserQueryService {

    MallUserCO find(ClientMallUserQuery clientMallUserQuery);

}
