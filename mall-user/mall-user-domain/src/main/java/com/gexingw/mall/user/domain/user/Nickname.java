package com.gexingw.mall.user.domain.user;

import com.gexingw.mall.common.core.support.ValueObject;
import lombok.Getter;

import java.util.UUID;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/12 22:28
 */
public class Nickname implements ValueObject<String> {

    @Getter
    private final String value;

    public Nickname() {
        this.value = "用户" + UUID.randomUUID();
    }

    public Nickname(String value) {
        this.value = value;
    }

}
