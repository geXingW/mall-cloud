package com.gexingw.mall.user.infra.config;

import com.gexingw.mall.user.domain.user.Nickname;
import org.apache.commons.lang3.StringUtils;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/14 12:56
 */
@SuppressWarnings("unused")
public class NicknameMapping {

    public String map(Nickname nickname) {
        return nickname.getValue();
    }

    public String map(Nickname nickname, String defaultNickname) {
        String value = nickname.getValue();
        if (StringUtils.isNotBlank(value)) {
            return value;
        }

        return defaultNickname;
    }

    public Nickname map(String nickname) {
        return new Nickname(nickname);
    }

    public Nickname map(String nickname, String defaultNickname) {
        if (StringUtils.isNotBlank(nickname)) {
            return new Nickname(nickname);
        }

        return new Nickname(defaultNickname);
    }

}
