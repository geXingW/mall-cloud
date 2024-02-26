package com.gexingw.mall.common.core.command;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/24 19:19
 */
@Component
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandHandler {

    @AliasFor("classes")
    Class<?>[] value() default {};

    Class<?>[] classes() default {};

}
