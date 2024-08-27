package com.gexingw.mall.common.security.support;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/27 11:08
 */
@SuppressWarnings("unused")
public class AuthUtil {

    public static @NotNull Long getAuthUserId() {
        return getAuthInfo().map(AuthInfo::getId).orElse(0L);
    }

    public static Optional<AuthInfo> getAuthInfo() {
        return getAuthentication().map(Authentication::getAuthInfo);
    }

    public static Optional<Authentication> getAuthentication() {
        return Optional.ofNullable((Authentication) SecurityContextHolder.getContext().getAuthentication());
    }

}
