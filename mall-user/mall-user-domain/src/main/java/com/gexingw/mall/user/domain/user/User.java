package com.gexingw.mall.user.domain.user;

import com.gexingw.mall.common.core.annotation.Default;
import com.gexingw.mall.common.core.domain.AggregationRoot;
import lombok.Getter;
import lombok.Setter;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/12 22:24
 */
@Getter
public class User implements AggregationRoot<Long> {

    @Setter
    public Long id;

    public Long authUserId;

    public Nickname nickname;

    public String phone;

    @Override
    public Long getId() {
        return this.id;
    }

    public User(Long authUserId, String phone) {
        this(null, authUserId, phone, new Nickname());
    }

    @Default
    public User(Long id, Long authUserId, String phone, Nickname nickname) {
        this.id = id;
        this.authUserId = authUserId;
        this.phone = phone;
        this.nickname = nickname;
    }

}
