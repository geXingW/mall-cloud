package com.gexingw.mall.user.app.service.impl;

import com.gexingw.mall.comm.core.util.R;
import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.user.client.clientobject.user.UserCO;
import com.gexingw.mall.user.client.dubbo.UserRpcService;
import com.gexingw.mall.user.infra.gatewayimpl.db.UserMapper;
import com.gexingw.mall.user.infra.dataobject.UserDO;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Lazy;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 17:34
 */
@DubboService
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class UserRpcServiceImpl implements UserRpcService {

    private final UserMapper userMapper;

    @Override
    public R<UserCO> getById(Long id) {
        UserDO userPo = userMapper.selectById(id);
        if (userPo == null) {
            throw new BizNotFoundException("用户信息不存在！");
        }

        return R.ok(new UserCO().setId(userPo.getId()).setName(userPo.getName()));
    }

}
