package com.gexingw.mall.common.core.support;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/14 11:45
 */
public interface ValueObject<T> extends Serializable {

    T getValue();

}
