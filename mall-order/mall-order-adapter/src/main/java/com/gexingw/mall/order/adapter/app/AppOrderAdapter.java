package com.gexingw.mall.order.adapter.app;

import com.gexingw.mall.common.core.command.CommandBus;
import com.gexingw.mall.common.core.enums.OrderRespCode;
import com.gexingw.mall.common.core.enums.CommonRespCode;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.order.app.dto.order.AppOrderCancelCommand;
import com.gexingw.mall.order.app.dto.order.AppOrderDeleteCommand;
import com.gexingw.mall.order.app.dto.order.AppOrderSubmitCommand;
import com.gexingw.mall.order.app.vo.order.AppOrderDetailVO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 15:31
 */
@RestController
@RequestMapping("/app")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AppOrderAdapter {

    private final CommandBus commandBus;

    @GetMapping
    public R<Object> list() {
        return R.ok();
    }

    @GetMapping("/{id}")
    public R<AppOrderDetailVO> info(@PathVariable Long id) {
        return R.ok();
    }

    @PostMapping
    public R<Long> add(@RequestBody AppOrderSubmitCommand addCommand) {
        return R.ok(commandBus.send(addCommand, Long.class));
    }

    @PostMapping("/{id}/cancel")
    public R<Object> cancel(@PathVariable Long id) {
        if (!commandBus.send(new AppOrderCancelCommand(id), Boolean.class)) {
            return R.fail(OrderRespCode.CANCEL_ERROR);
        }

        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Object> delete(@PathVariable Long id) {
        if (commandBus.send(new AppOrderDeleteCommand(id), Boolean.class)) {
            R.fail(CommonRespCode.DELETE_ERROR);
        }

        return R.ok();
    }

}
