package com.gexingw.mall.user.adapter.web;

import com.gexingw.mall.comm.core.util.R;
import com.gexingw.mall.user.app.executor.shippingaddress.ShippingAddressAddCmdExecutor;
import com.gexingw.mall.user.app.executor.shippingaddress.ShippingAddressQueryExecutor;
import com.gexingw.mall.user.app.service.ShippingAddressService;
import com.gexingw.mall.user.app.vo.address.ShippingAddressListVO;
import com.gexingw.mall.user.app.vo.address.ShippingAddressVO;
import com.gexingw.mall.user.domain.address.dto.ShippingAddressAddCommand;
import com.gexingw.mall.user.domain.address.dto.ShippingAddressListQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/4 21:35
 */
@RestController
@RequestMapping("/web/shipping-address")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class WebShippingAddressAdapter {

    private final ShippingAddressService shippingAddressService;
    private final ShippingAddressAddCmdExecutor shippingAddressAddCmdExecutor;
    private final ShippingAddressQueryExecutor shippingAddressQueryExecutor;

    @GetMapping
    public R<List<ShippingAddressListVO>> list(ShippingAddressListQuery query) {
        return R.ok(shippingAddressQueryExecutor.execute(query));
    }

    @GetMapping("/{id}")
    public R<ShippingAddressVO> info(@PathVariable Long id) {
        return R.ok(shippingAddressService.getById(id));
    }

    @PostMapping
    public R<Long> add(@RequestBody ShippingAddressAddCommand addCommand) {
        return R.ok(shippingAddressAddCmdExecutor.execute(addCommand));
    }

}
