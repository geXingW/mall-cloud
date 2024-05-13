package com.gexingw.mall.common.core.support;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/13 14:51
 */
public interface DiffChange {

    void setNewValue(Object newValue);

    Object getNewValue();

    void setOldValue(Object oldValue);

    Object getOldValue();

}
