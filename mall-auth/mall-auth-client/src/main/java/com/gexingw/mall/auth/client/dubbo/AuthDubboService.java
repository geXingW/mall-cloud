package com.gexingw.mall.auth.client.dubbo;

import com.gexingw.mall.common.core.util.R;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/27 15:13
 */
public interface AuthDubboService {

    R<Boolean> logout(String accessToken);

}
