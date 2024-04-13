package com.gexingw.mall.common.core.support;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GeXingW
 */
@Data
public class BaseQuery implements Serializable {

    /**
     * 当前页
     */
    private final int page = 1;

    /**
     * 每页数量
     */
    private final int size = 10;

    /**
     * 搜索关键字
     */
    private String keyword;


}
