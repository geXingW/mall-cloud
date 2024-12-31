package top.gexingw.mall.client.user.web.app.assembler;

import org.mapstruct.Mapper;
import top.gexingw.mall.client.user.web.app.vo.WebAuthTokenVO;
import top.gexingw.mall.service.user.client.co.mall.user.MallUserAuthTokenCO;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/19 16:20
 */
@Mapper(componentModel = "spring")
public interface AuthAssembler {

    WebAuthTokenVO toTokenVO(MallUserAuthTokenCO login);

}
