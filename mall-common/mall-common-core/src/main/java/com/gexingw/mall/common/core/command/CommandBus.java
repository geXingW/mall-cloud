package com.gexingw.mall.common.core.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mall-user-service
 * 命令总线
 *
 * @author GeXingW
 * @date 2024/2/24 17:49
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
     * @param command      命令
     * @param responseType 响应类型
     * @param <T>          响应类型的泛型，调用方自定义返回参数类型
     * @return T
     */
    public <T> T send(ICommand command, Class<T> responseType) {
        // 从Repository中获取，避免遍历匹配
        ICommandHandler commandHandler = repository.get(command.getClass());
        if (commandHandler == null) {
            // 如果从Repository获取不到，遍历Map
            commandHandler = getHandler(command.getClass());

            // 存入repository中，避免后续遍历
            repository.put(command.getClass(), commandHandler);
        }

        // 调用CommandHandler执行Command
        return commandHandler.execute(command, responseType);
    }

    /**
     * 根据命令类型来查找CommandHandler
     * CommandHandler注解需要标注执行的Command类型
     *
     * @param commandClazz Command类型
     * @return CommandHandler
     */
    public ICommandHandler getHandler(Class<? extends ICommand> commandClazz) {
        for (ICommandHandler handler : handlers) {
            // 获取CommandHandler注解标注的Command类型
            CommandHandler commandHandlerAnnotation = handler.getClass().getAnnotation(CommandHandler.class);

            // 一个CommandHandler可以匹配多个Command类型的任务
//            for (Class<?> aClass : commandHandlerAnnotation.commands()) {
//                // 类型匹配检查
//                if (aClass.isAssignableFrom(commandClazz)) {
//                    return handler;
//                }
//            }
        }

        throw new RuntimeException("CommandHandler for command " + commandClazz.getName() + " not found");
    }

}
