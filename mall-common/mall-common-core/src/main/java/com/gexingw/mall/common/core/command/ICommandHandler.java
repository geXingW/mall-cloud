package com.gexingw.mall.common.core.command;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/24 21:01
 */
public interface ICommandHandler {

    /**
     * 执行Command命令
     *
     * @param command 命令
     */
    default <T> T execute(ICommand command, Class<T> responseType) {
        System.out.println("Do noting...");

        return null;
    }

}
