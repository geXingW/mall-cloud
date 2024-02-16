package com.gexingw.mall.user.client.dubbo;


import com.gexingw.mall.comm.core.util.R;
import com.gexingw.mall.user.client.clientobject.user.UserCO;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 14:26
 */
public interface UserRpcService {

    R<UserCO> getById(Long id);

}
