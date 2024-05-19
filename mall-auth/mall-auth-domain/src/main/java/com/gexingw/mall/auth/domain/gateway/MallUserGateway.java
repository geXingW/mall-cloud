package com.gexingw.mall.auth.domain.gateway;

import com.gexingw.mall.auth.domain.model.MallUser;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/17 17:30
 */
public interface MallUserGateway {

    MallUser selectById(Long id);

    Long insert(MallUser mallUser);

}
