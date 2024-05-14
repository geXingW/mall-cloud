package com.gexingw.mall.common.core.support;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/14 16:08
 */
@Retention(RetentionPolicy.CLASS)
@Mapping(target = "id", ignore = true)
public @interface ValueObject {

}
