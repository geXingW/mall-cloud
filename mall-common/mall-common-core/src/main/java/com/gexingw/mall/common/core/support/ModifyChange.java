package com.gexingw.mall.common.core.support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/13 14:52
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModifyChange implements DiffChange {

    private Long id;

    private String propertyName;

    private Object oldValue;

    private Object newValue;

}
