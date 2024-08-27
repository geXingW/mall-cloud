package com.gexingw.mall.auth.application.service;

import org.jetbrains.annotations.Nullable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/27 13:01
 */
public interface AuthCommandService {

    void logout(@Nullable String accessToken);

}
