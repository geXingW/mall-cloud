package com.gexingw.mall.order.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.support.BasePO;
import lombok.Data;
import lombok.experimental.Accessors;
import top.gexingw.ddd.core.AggregateRoot;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/26 16:50
 */
@Data
@Accessors(chain = true)
@TableName(value = "order_event", excludeProperty = {"updateUser", "updateTime", "isDeleted"})
public class OrderDomainEventDO extends BasePO {

    private Long eventId;

    private String eventType;

    private AggregateRoot eventPayload;

}
