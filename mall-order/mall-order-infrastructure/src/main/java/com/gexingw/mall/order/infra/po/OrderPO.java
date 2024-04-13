package com.gexingw.mall.order.infra.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.dataobject.BaseDO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author GeXingW
 */
@Data
@TableName("`order`")
@Accessors(chain = true)
public class OrderPO extends BaseDO {

    private String number;

    private BigDecimal totalAmount;

    private Integer totalQuantity;

}
