package com.gexingw.mall.order.adapter.app;

import com.gexingw.mall.comm.core.util.R;
import com.gexingw.mall.order.app.command.executor.OrderCommandExecutor;
import com.gexingw.mall.order.app.dto.OrderAddCommand;
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

    private final OrderCommandExecutor commandExecutor;

    @GetMapping("/{id}")
    public R<AppOrderDetailVO> info(@PathVariable Long id) {
        return R.ok(commandExecutor.getById(id));
    }

    @PostMapping
    public R<Long> add(@RequestBody OrderAddCommand addCommand) {
        return R.ok(commandExecutor.add(addCommand));
    }

    @DeleteMapping("/{id}")
    public R<Object> delete(@PathVariable Long id) {
        return R.ok(commandExecutor.delete(id));
    }

}
