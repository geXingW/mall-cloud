package com.gexingw.mall.common.db.util;

import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/7 15:22
 */
@SuppressWarnings("unused")
public class TransactionUtil {

    public static void afterCommittedCallback(Runnable callback) {
        TransactionSynchronizationManager.registerSynchronization(new TransactionCompletionCallback(callback));
    }

}
