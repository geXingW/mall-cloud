package top.gexingw.mall.client.user.web.infra.convert.user;

import org.mapstruct.Mapper;
import top.gexingw.mall.client.user.web.infra.rpc.user.mall.user.MallUserDTO;
import top.gexingw.mall.service.user.client.co.mall.user.MallUserCO;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/18 18:27
 */
@Mapper(componentModel = "spring")
public interface MallUserConvert {

    MallUserDTO toClientDTO(MallUserCO data);

}
