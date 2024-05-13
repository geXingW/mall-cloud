package com.gexingw.mall.common.core.support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/13 14:53
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RemoveChange implements DiffChange {

    private Object oldValue;

    private Object newValue;

}
