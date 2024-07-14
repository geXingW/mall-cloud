package com.gexingw.mall.user.domain.user;

import com.gexingw.mall.common.core.support.Repository;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/4 12:09
 */
public interface UserRepository extends Repository<User, Long> {

    User findByPhone(String phone);

}
