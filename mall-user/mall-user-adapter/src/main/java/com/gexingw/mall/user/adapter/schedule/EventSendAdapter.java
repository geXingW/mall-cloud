package com.gexingw.mall.user.adapter.schedule;

import com.gexingw.mall.common.core.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/24 14:01
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@RequestMapping("/schedule/event/send")
public class EventSendAdapter {


    @GetMapping
    public R<Object> send() {
        return R.ok();
    }

}
