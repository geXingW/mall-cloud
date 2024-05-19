package com.gexingw.mall.auth.infrastructure.gateway.authuser.db;

import com.gexingw.mall.auth.infrastructure.po.AuthUserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/19 21:58
 */
@Repository
public interface AuthUserDAO extends JpaRepository<AuthUserPO, Long> {

    AuthUserPO findByUsername(String username);

}
