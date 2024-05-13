package com.gexingw.mall.common.exception;

import com.gexingw.mall.common.core.interfaces.IRespCode;
import com.gexingw.mall.common.core.util.R;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

import static org.apache.dubbo.common.constants.CommonConstants.PROVIDER;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/13 12:44
 */
@ConditionalOnClass(Filter.class)
@Activate(group = {PROVIDER}, order = 999999)
public class DubboRpcExceptionHandler implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result invokeResult = invoker.invoke(invocation);

        if (invokeResult.hasException() && invoker.getInterface() != GenericService.class) {
            Throwable exception = invokeResult.getException();
//            // 非运行时异常直接抛出
//            if (!(exception instanceof RuntimeException)) {
//                return invokeResult;
//            }

            if (exception instanceof BizErrorException) {
                IRespCode respCode = ((BizErrorException) exception).getRespCode();
                invokeResult.setValue(R.fail(respCode));
                invokeResult.setException(null);

                return invokeResult;
            }


            invokeResult.setException(null);
            return invokeResult;
        }

        return invokeResult;
    }

}
