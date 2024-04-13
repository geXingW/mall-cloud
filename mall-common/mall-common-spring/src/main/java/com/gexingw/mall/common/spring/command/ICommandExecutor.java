package com.gexingw.mall.common.spring.command;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/24 21:01
 */
public interface ICommandExecutor {

    /**
     * 执行Command命令
     *
     * @param command 命令
     */
    default Object handleWithResult(ICommand command) {
        throw new RuntimeException("未实现该方法!");
    }

    default void handleWithoutResult(ICommand command) {
        throw new RuntimeException("未实现该方法!");
    }

}
