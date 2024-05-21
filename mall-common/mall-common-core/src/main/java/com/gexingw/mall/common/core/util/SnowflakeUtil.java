package com.gexingw.mall.common.core.util;

import com.gexingw.mall.common.core.support.Snowflake;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/20 22:02
 */
public class SnowflakeUtil {

    private static final Snowflake SNOWFLAKE_INSTANCE;

    static {
        SNOWFLAKE_INSTANCE = new Snowflake();
    }

    public static long nextId() {
        return SNOWFLAKE_INSTANCE.nextId();
    }

}
