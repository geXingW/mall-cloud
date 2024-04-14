package com.gexingw.mall.order.adapter.app;

import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.order.app.command.address.ShippingAddressSaveCmd;
import com.gexingw.mall.order.app.service.ShippingAddressService;
import com.gexingw.mall.order.infrastructure.query.order.AppShippingAddressQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

/**
 * @author GeXingW
 */
@RestController
@RequestMapping("/app/shipping-address")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AppShippingAddressAdapter {

    private final ShippingAddressService shippingAddressService;

    @GetMapping
    private R<Object> index(AppShippingAddressQuery query) {
        return R.ok(shippingAddressService.queryAppPage(query));
    }

    @PostMapping
    public R<Long> save(@RequestBody ShippingAddressSaveCmd saveCommand) {
        return R.ok(shippingAddressService.save(saveCommand));
    }

}
