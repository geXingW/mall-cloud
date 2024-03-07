package com.gexingw.mall.common.db.util;

import org.springframework.transaction.support.TransactionSynchronization;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/3/7 15:24
 */
public class TransactionCompletionCallback implements TransactionSynchronization {

    private final Runnable callback;

    public TransactionCompletionCallback(Runnable callback) {
        this.callback = callback;
    }

    @Override
    public void afterCompletion(int status) {
        if (TransactionSynchronization.STATUS_COMMITTED == status) {
            this.callback.run();
        }
    }

}
