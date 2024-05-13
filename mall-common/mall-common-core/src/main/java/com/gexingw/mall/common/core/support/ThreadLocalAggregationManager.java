package com.gexingw.mall.common.core.support;

import com.alibaba.fastjson2.JSON;
import com.gexingw.mall.common.core.domain.AggregationManager;
import com.gexingw.mall.common.core.domain.AggregationRoot;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/10 12:23
 */
public class ThreadLocalAggregationManager<T extends AggregationRoot<ID>, ID extends Serializable> implements AggregationManager<T, ID> {

    private final ThreadLocal<ThreadLocalContext<T, ID>> threadLocalContext = ThreadLocal.withInitial(ThreadLocalContext::new);

    @Override
    public T get(ID id) {
        return threadLocalContext.get().get(id);
    }

    @Override
    public AggregationRoot<ID> set(T aggregationRoot) {
        return threadLocalContext.get().set(aggregationRoot.getId(), aggregationRoot);
    }

    @Override
    public void remove(T aggregationRoot) {
        threadLocalContext.get().remove(aggregationRoot.getId());
    }

    @Override
    public void remove(ID id) {
        threadLocalContext.get().remove(id);
    }

    private static class ThreadLocalContext<T extends AggregationRoot<ID>, ID extends Serializable> {

        private Class<? extends T> clazz;

        private final Map<ID, T> aggregationRootMap = new HashMap<>();

        public T get(ID id) {
            return aggregationRootMap.get(id);
        }

        public T set(ID id, T aggregationRoot) {
            T aggregationRootCopy = JSON.copy(aggregationRoot);
            aggregationRootMap.put(id, aggregationRootCopy);

            return aggregationRootCopy;
        }

        public void remove(ID id) {
            aggregationRootMap.remove(id);
        }

    }

}
