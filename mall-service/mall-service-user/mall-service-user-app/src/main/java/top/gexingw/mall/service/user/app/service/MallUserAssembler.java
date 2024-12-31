package top.gexingw.mall.service.user.app.service;

import org.mapstruct.Mapper;
import top.gexingw.mall.service.user.client.co.mall.user.MallUserCO;
import top.gexingw.mall.service.user.dao.mall.user.MallUserPO;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/19 17:48
 */
@Mapper(componentModel = "spring")
public interface MallUserAssembler {

    MallUserCO toVO(MallUserPO mallUserPO);

}
