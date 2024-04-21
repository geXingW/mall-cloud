package com.gexingw.mall.common.spring.command;

import com.gexingw.mall.common.core.support.ICommand;
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

    @AliasFor("commands")
    Class<? extends ICommand>[] value() default {};

    @AliasFor("value")
    Class<? extends ICommand>[] commands() default {};

}
