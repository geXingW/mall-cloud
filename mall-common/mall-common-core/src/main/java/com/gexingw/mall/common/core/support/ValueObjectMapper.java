package com.gexingw.mall.common.core.support;


/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/14 12:04
 */
public class ValueObjectMapper<T> {

    T map(ValueObject<T> valueObject) {
        return valueObject.getValue();
    }

    ValueObject<T> map(T value) {
        return new ValueObject<T>() {
            @Override
            public T getValue() {
                return value;
            }
        };
    }
}
