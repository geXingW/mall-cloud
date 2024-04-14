package com.gexingw.mall.order.infrastructure.gateway.address.db;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gexingw.mall.common.db.mapper.BaseMapper;
import com.gexingw.mall.order.infrastructure.dto.address.AppShippingAddressListDTO;
import com.gexingw.mall.order.infrastructure.po.ShippingAddressPO;
import com.gexingw.mall.order.infrastructure.query.order.AppShippingAddressQuery;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author GeXingW
 */
@Mapper
public interface ShippingAddressMapper extends BaseMapper<ShippingAddressPO> {

    IPage<AppShippingAddressListDTO> queryAppPage(Page<Object> page, AppShippingAddressQuery query);

}
