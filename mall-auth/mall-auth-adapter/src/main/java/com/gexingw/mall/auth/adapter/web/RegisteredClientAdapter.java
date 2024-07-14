package com.gexingw.mall.auth.adapter.web;

import com.gexingw.mall.auth.application.command.client.RegisteredClientAddCmd;
import com.gexingw.mall.auth.application.vo.RegisteredClientCreateResultVO;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.spring.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/16 15:33
 */
@RestController
@RequestMapping("/web/registered-client")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class RegisteredClientAdapter {

    private final CommandBus commandBus;

    @PostMapping
    public R<RegisteredClientCreateResultVO> create(@RequestBody RegisteredClientAddCmd registeredClientAddCmd) {
        return R.ok(commandBus.execute(registeredClientAddCmd, RegisteredClientCreateResultVO.class));
    }

}
