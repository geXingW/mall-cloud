package top.gexingw.mall.service.user.domain.mall.user;

import top.gexingw.ddd.core.Repository;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/10/18 18:13
 */
public interface MallUserRepository extends Repository<MallUser, Long> {

    MallUser findByPhone(String phone);

}
