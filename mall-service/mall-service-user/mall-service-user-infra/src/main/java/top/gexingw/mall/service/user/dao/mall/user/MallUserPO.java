package top.gexingw.mall.service.user.dao.mall.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gexingw.mall.common.db.support.BasePO;
import lombok.Data;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/19 16:36
 */
@Data
@TableName("mall_user")
public class MallUserPO extends BasePO {

    private Long authUserId;

    private String username;

    private String phone;

}
