package com.gexingw.mall.common.spring.event;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 17:09
 */
@Component
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {

    @AliasFor("handlers")
    Class<?>[] value() default {};

    @SuppressWarnings("unused")
    Class<?>[] handlers() default {};

}
