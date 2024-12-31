package top.gexingw.mall.service.user.adapter.dubbo;

import com.gexingw.mall.common.core.util.R;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Lazy;
import top.gexingw.mall.service.user.app.service.MallUserCommandService;
import top.gexingw.mall.service.user.app.service.MallUserQueryService;
import top.gexingw.mall.service.user.client.co.mall.user.MallUserAuthTokenCO;
import top.gexingw.mall.service.user.client.co.mall.user.MallUserCO;
import top.gexingw.mall.service.user.client.command.mall.user.ClientMallUserCreateCommand;
import top.gexingw.mall.service.user.client.dubbo.DubboMallUserClient;
import top.gexingw.mall.service.user.client.query.mall.user.ClientMallUserQuery;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/10/18 13:57
 */
@DubboService
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class DubboMallUserAdapter implements DubboMallUserClient {

    private final MallUserCommandService mallUserCommandService;
    private final MallUserQueryService mallUserQueryService;

    @Override
    public R<MallUserCO> find(ClientMallUserQuery clientMallUserQuery) {
        return R.ok(mallUserQueryService.find(clientMallUserQuery));
    }

    @Override
    public R<Long> create(ClientMallUserCreateCommand command) {
        return R.ok(mallUserCommandService.create(command));
    }

    @Override
    public R<MallUserAuthTokenCO> login(String phone, String password) {
        return R.ok(mallUserCommandService.login(phone, password));
    }

}
