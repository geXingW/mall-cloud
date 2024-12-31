package top.gexingw.mall.service.user.infra.convert;

import org.mapstruct.Mapper;
import top.gexingw.mall.service.user.dao.mall.user.MallUserPO;
import top.gexingw.mall.service.user.domain.mall.user.MallUser;

@Mapper(componentModel = "spring")
public interface MallUserConvert {

    MallUserPO toPO(MallUser mallUser);

}
