package com.gexingw.mall.order.infra.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.dataobject.BaseDO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:21
 */
@Data
@TableName("`order`")
@Accessors(chain = true)
public class OrderDO extends BaseDO {

    private String number;

    private BigDecimal totalAmount;

    private Integer totalQuantity;

}
