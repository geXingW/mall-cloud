package com.gexingw.mall.common.spring.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 19:19
 */
@Component
@SuppressWarnings("unused")
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return clazz == null ? null : context.getBean(clazz);
    }

    public static Object getBean(String beanId) {
        return beanId == null ? null : context.getBean(beanId);
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        if (StringUtils.isNotBlank(beanName)) {
            return clazz == null ? null : context.getBean(beanName, clazz);
        }

        return null;
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return context.getBeansOfType(type);
    }

    public static ApplicationContext getContext() {
        return context == null ? null : context;
    }

}
