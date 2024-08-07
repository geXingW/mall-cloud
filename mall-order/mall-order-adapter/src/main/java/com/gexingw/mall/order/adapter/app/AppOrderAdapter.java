package com.gexingw.mall.order.adapter.app;

import com.gexingw.mall.common.core.enums.CommonRespCode;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.db.support.Pager;
import com.gexingw.mall.common.spring.command.CommandBus;
import com.gexingw.mall.order.app.command.order.AppOrderCancelCommand;
import com.gexingw.mall.order.app.command.order.AppOrderChangeShippingAddressCmd;
import com.gexingw.mall.order.app.command.order.AppOrderDeleteCommand;
import com.gexingw.mall.order.app.command.order.AppOrderSubmitCommand;
import com.gexingw.mall.order.app.service.OrderService;
import com.gexingw.mall.order.app.vo.order.AppOrderDetailVO;
import com.gexingw.mall.order.app.vo.order.AppOrderListVO;
import com.gexingw.mall.order.infrastructure.query.order.AppOrderQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 15:31
 */
@RestController
@RequestMapping("/app/order")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AppOrderAdapter {

    private final CommandBus commandBus;
    private final OrderService orderService;

    @GetMapping
    public R<Pager<AppOrderListVO>> list(AppOrderQuery query) {
        return R.ok(orderService.queryAppPage(query));
    }

    @GetMapping("/{id}")
    public R<AppOrderDetailVO> info(@PathVariable Long id) {
        return R.ok(new AppOrderDetailVO().setId(id));
    }

    @PostMapping
    public R<Long> add(@Validated @RequestBody AppOrderSubmitCommand addCommand) {
        return R.ok(commandBus.execute(addCommand, Long.class));
    }

    @PostMapping("/{id}/cancel")
    public R<Object> cancel(@PathVariable Long id) {
        commandBus.execute(new AppOrderCancelCommand(id));

        return R.ok();
    }

    @PostMapping("/{id}/shipping-address")
    public R<Object> changeShippingAddress(@PathVariable Long id, @RequestBody AppOrderChangeShippingAddressCmd cmd) {
        commandBus.execute(cmd.setId(id));

        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Object> delete(@PathVariable Long id) {
        if (commandBus.execute(new AppOrderDeleteCommand(id), Boolean.class)) {
            R.fail(CommonRespCode.DELETE_ERROR);
        }

        return R.ok();
    }

}
