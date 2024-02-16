package com.gexingw.mall.order.infra.gateway.rpc;

import com.gexingw.mall.comm.core.util.R;
import com.gexingw.mall.user.client.clientobject.user.UserCO;
import com.gexingw.mall.user.client.dubbo.UserRpcService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:17
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class UserRpcMapper {

    @DubboReference
    private UserRpcService userRpcService;

    public UserCO getById(Long id) {
        R<UserCO> getResult = userRpcService.getById(id);
        if (!getResult.isSuccess()) {
            return null;
        }

        return getResult.getData();
    }

}
