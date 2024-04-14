package com.gexingw.mall.common.db.support;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author GeXingW
 */
@NoArgsConstructor
public class Pager<T> implements IPage<T> {

    @Getter
    @Setter
    @Accessors(chain = true)
    protected List<T> records = new ArrayList<>();

    @Getter
    @Setter
    @Accessors(chain = true)
    protected long total = 0;

    @Getter
    @Setter
    @Accessors(chain = true)
    protected long size = 0;

    protected List<OrderItem> orders = new ArrayList<>();

    @Getter
    @Setter
    @Accessors(chain = true)
    protected long page;

    @Getter
    @Setter
    @Accessors(chain = true)
    @JsonIgnore
    protected boolean searchCount;

    public Pager(long page, long size) {
        this.page = page;
        this.size = size;
        this.total = 0L;
        this.searchCount = true;
    }

    public Pager(long page, long size, long total) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.searchCount = true;
    }

    public Pager(long page, long size, long total, boolean searchCount) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.searchCount = searchCount;
    }

    public Pager(long page, long size, long total, List<T> records) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.records = records;
    }

    public static <T> Pager<T> of(long page, long size) {
        return of(page, size, 0L);
    }

    public static <T> Pager<T> of(long page, long size, long total) {
        return of(page, size, total, true);
    }

    public static <T> Pager<T> of(long page, long size, long total, List<T> records) {
        return new Pager<>(page, size, total, records);
    }

    public static <T> Pager<T> of(long page, long size, boolean searchCount) {
        return of(page, size, 0L, searchCount);
    }

    public static <T> Pager<T> of(long page, long size, long total, boolean searchCount) {
        return new Pager<>(page, size, total, searchCount);
    }

    @SuppressWarnings("unused")
    public Pager<T> addOrder(OrderItem... items) {
        this.orders.addAll(Arrays.asList(items));
        return this;
    }

    @SuppressWarnings("unused")
    public Pager<T> addOrder(List<OrderItem> items) {
        this.orders.addAll(items);
        return this;
    }

    @Override
    public List<OrderItem> orders() {
        return this.orders;
    }

    @Override
    @JsonIgnore
    public long getCurrent() {
        return this.page;
    }

    @Override
    public Pager<T> setCurrent(long current) {
        this.page = current;
        return this;
    }

    @Override
    @JsonIgnore
    public long getPages() {
        if (this.getSize() == 0L) {
            return 0L;
        }

        long pages = this.getTotal() / this.getSize();
        if (this.getTotal() % this.getSize() != 0L) {
            ++pages;
        }

        return pages;
    }
}
