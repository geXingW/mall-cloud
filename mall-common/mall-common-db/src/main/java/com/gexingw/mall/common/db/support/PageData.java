package com.gexingw.mall.common.db.support;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author GeXingW
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PageData<T> implements Serializable {

    private long page;

    private long size;

    private long total;

    private List<T> records = new ArrayList<>();

    public PageData(int page, int size) {
        this(page, size, 0, Collections.emptyList());
    }

    public PageData(IPage<T> page) {
        this(page.getCurrent(), page.getSize(), page.getTotal(), page.getRecords());
    }

}
