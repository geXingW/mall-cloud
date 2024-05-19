package com.gexingw.mall.auth.domain.model;

import cn.hutool.core.util.RandomUtil;
import com.gexingw.mall.common.core.domain.AggregationRoot;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 23:00
 */
@Data
@NoArgsConstructor
public class RegisteredClient implements AggregationRoot<Long> {

    private Long id;

    private String clientName;

    private String clientId;

    private String clientSecret;

    private Set<String> scopes;

    public RegisteredClient(String clientName, Set<String> scopes) {
        this.clientName = clientName;
        this.clientId = RandomUtil.randomString(15);
        this.clientSecret = RandomUtil.randomString(30);
        this.scopes = scopes;
    }

}
