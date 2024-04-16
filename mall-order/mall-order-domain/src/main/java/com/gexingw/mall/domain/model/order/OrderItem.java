package com.gexingw.mall.domain.model.order;

import com.gexingw.mall.common.exception.BizNotFoundException;
import com.gexingw.mall.common.exception.ParamInvalidException;
import com.gexingw.mall.domain.model.product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:00
 */
@Data
@NoArgsConstructor
public class OrderItem implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(OrderItem.class);

    private Long orderId;

    private String orderNo;

    private Long productId;

    private String productNo;

    private String productName;

    private BigDecimal productSalePrice;

    private BigDecimal productMarketPrice;

    private String productPic;

    private Integer quantity;

    private String image;

    public BigDecimal getTotalAmount() {
        if (ObjectUtils.anyNull(productSalePrice, quantity)) {
            log.warn("price or quantity is null. {}", this);
            return BigDecimal.ZERO;
        }

        return productMarketPrice.multiply(new BigDecimal(quantity));
    }

    public OrderItem(Product product) {
        if (product == null) {
            throw new BizNotFoundException("商品不存在!");
        }

        if (BigDecimal.ZERO.compareTo(product.getSalePrice()) >= 0) {
            throw new BizNotFoundException("商品价格不能为0！");
        }

        this.productId = product.getId();
        this.productNo = product.getNumber();
        this.productName = product.getName();
        this.productSalePrice = product.getSalePrice();
        this.productMarketPrice = product.getMarketPrice();
    }

    public OrderItem setQuantity(Integer quantity) {
        if (quantity <= 0) {
            throw new ParamInvalidException("最少买一件商品");
        }

        this.quantity = quantity;
        return this;
    }

    public OrderItem setOrder(Order order) {
        if (StringUtils.isAnyBlank("" + order.getId(), order.getNumber())) {
            throw new ParamInvalidException("订单Id和订单号不能为空！");
        }

        this.orderId = order.getId();
        this.orderNo = order.getNumber();

        return this;
    }

}
