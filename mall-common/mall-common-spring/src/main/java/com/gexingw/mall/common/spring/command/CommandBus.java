package com.gexingw.mall.common.spring.command;

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

    private final Map<Class<? extends ICommand>, ICommandHandler> repository = new HashMap<>();

    @Autowired(required = false)
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    private List<ICommandHandler> handlers = new ArrayList<>();

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
        // 从Repository中获取，避免遍历匹配
        ICommandHandler commandHandler = repository.get(command.getClass());
        if (commandHandler == null) {
            // 如果从Repository获取不到，遍历Map
            commandHandler = getHandler(command.getClass());

            // 存入repository中，避免后续遍历
            repository.put(command.getClass(), commandHandler);
        }

        // 调用CommandHandler执行Command
        return (T) commandHandler.handleWithResult(command);
    }

    public void execute(ICommand command) {
        ICommandHandler handler = getHandler(command.getClass());
        handler.handleWithoutResult(command);
    }

    public ICommandHandler getHandler(Class<? extends ICommand> commandClazz) {
        ICommandHandler commandHandler = repository.get(commandClazz);
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
    public ICommandHandler findHandler(Class<? extends ICommand> commandClazz) {
        for (ICommandHandler handler : handlers) {
            // 获取CommandHandler注解标注的Command类型
            CommandHandler commandHandlerAnnotation = AnnotationUtils.findAnnotation(handler.getClass(), CommandHandler.class);
            if (commandHandlerAnnotation == null) {
                continue;
            }

            // 一个CommandHandler可以匹配多个Command类型的任务
            Class<?>[] commands = commandHandlerAnnotation.commands();
            for (Class<?> command : commands) {
                if (command.isAssignableFrom(commandClazz)) {
                    return handler;
                }
            }
        }

        throw new RuntimeException("CommandHandler for command " + commandClazz.getName() + " not found");
    }

}
