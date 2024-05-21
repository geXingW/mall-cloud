package com.gexingw.mall.common.spring.util;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
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

    @NotNull
    public static <T> T getBean(Class<T> clazz) {
        if (clazz == null) {
            throw new NoSuchBeanDefinitionException("null");
        }

        return context.getBean(clazz);
    }

    @NotNull
    public static Object getBean(String beanId) {
        if (beanId == null) {
            throw new NoSuchBeanDefinitionException("null");
        }

        return context.getBean(beanId);
    }

    @NotNull
    public static <T> T getBean(String beanName, Class<T> clazz) {
        if (StringUtils.isBlank(beanName) || clazz == null) {
            throw new NoSuchBeanDefinitionException("null");
        }

        return context.getBean(beanName, clazz);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return context.getBeansOfType(type);
    }

    public static ApplicationContext getContext() {
        return context == null ? null : context;
    }

}
