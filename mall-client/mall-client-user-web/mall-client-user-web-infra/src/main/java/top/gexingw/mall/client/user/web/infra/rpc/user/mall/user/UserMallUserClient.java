package top.gexingw.mall.client.user.web.infra.rpc.user.mall.user;

import com.gexingw.mall.common.core.util.R;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import top.gexingw.mall.client.user.web.infra.convert.user.MallUserConvert;
import top.gexingw.mall.service.user.client.co.mall.user.MallUserAuthTokenCO;
import top.gexingw.mall.service.user.client.co.mall.user.MallUserCO;
import top.gexingw.mall.service.user.client.command.mall.user.ClientMallUserCreateCommand;
import top.gexingw.mall.service.user.client.dubbo.DubboMallUserClient;
import top.gexingw.mall.service.user.client.query.mall.user.ClientMallUserQuery;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/18 14:36
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class UserMallUserClient {

    @DubboReference
    private DubboMallUserClient dubboMallUserClient;

    private final MallUserConvert mallUserConvert;

    public MallUserDTO findByPhone(String phone) {
        R<MallUserCO> findResult = dubboMallUserClient.find(new ClientMallUserQuery().setPhone(phone));
        // 用户未找到
        if(404 == findResult.getCode()) {
            return null;
        }

        if (!findResult.isSuccess()) {
            throw new RuntimeException("用户信息查询失败！");
        }

        return mallUserConvert.toClientDTO(findResult.getData());
    }

    public Long create(String phone, String password) {
        ClientMallUserCreateCommand createCommand = new ClientMallUserCreateCommand(phone, phone, password);
        R<Long> createResult = dubboMallUserClient.create(createCommand);
        if (!createResult.isSuccess()) {
            throw new RuntimeException("用户创建失败！");
        }

        return createResult.getData();
    }

    public MallUserAuthTokenCO login(String phone, String password) {
        R<MallUserAuthTokenCO> loginResult = dubboMallUserClient.login(phone, password);
        if (!loginResult.isSuccess()) {
            throw new RuntimeException("用户登录失败！");
        }

        return loginResult.getData();
    }

}
