package com.gexingw.mall.auth.infrastructure.gateway.regsteredclient.db;

import com.gexingw.mall.auth.infrastructure.po.RegisteredClientPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/19 22:16
 */
@Repository
public interface RegisteredClientDAO extends JpaRepository<RegisteredClientPO, Long> {

}
