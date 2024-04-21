package com.gexingw.mall.common.spring.command;

import com.gexingw.mall.common.core.support.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/11 9:53
 */
@Component
public class CommandBus {

    private final Map<Class<? extends ICommand>, ICommandExecutor> repository = new HashMap<>();

    @Autowired(required = false)
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    private List<ICommandExecutor> handlers = new ArrayList<>();

    /**
     * 1、自动匹配CommandHandler
     * 2、自动调用CommandHandler执行Command
     *
     * @param command 命令
     * @param <T>     响应类型的泛型，调用方自定义返回参数类型
     * @return T
     */
    @SuppressWarnings({"unused", "unchecked"})
    public <T> T execute(ICommand command, Class<T> resultType) {
        ICommandExecutor handler = getHandler(command.getClass());
        // 调用CommandHandler执行Command
        return (T) handler.handleWithResult(command);
    }

    public void execute(ICommand command) {
        ICommandExecutor handler = getHandler(command.getClass());
        handler.handleWithoutResult(command);
    }

    public ICommandExecutor getHandler(Class<? extends ICommand> commandClazz) {
        ICommandExecutor commandHandler = repository.get(commandClazz);
        if (commandHandler != null) {
            return commandHandler;
        }

        return findHandler(commandClazz);
    }

    /**
     * 根据命令类型来查找CommandHandler
     * CommandHandler注解需要标注执行的Command类型
     *
     * @param commandClazz Command类型
     * @return CommandHandler
     */
    public ICommandExecutor findHandler(Class<? extends ICommand> commandClazz) {
        for (ICommandExecutor handler : handlers) {
            // 获取CommandHandler注解标注的Command类型
            CommandHandler commandHandlerAnnotation = AnnotationUtils.findAnnotation(handler.getClass(), CommandHandler.class);
            if (commandHandlerAnnotation == null) {
                continue;
            }

            // 一个CommandHandler可以匹配多个Command类型的任务
            Class<?>[] commands = commandHandlerAnnotation.commands();
            for (Class<?> command : commands) {
                if (command.isAssignableFrom(commandClazz)) {
                    repository.put(commandClazz, handler);
                    return handler;
                }
            }
        }

        throw new RuntimeException("CommandHandler for command " + commandClazz.getName() + " not found");
    }

}
