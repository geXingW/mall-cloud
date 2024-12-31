package top.gexingw.mall.service.user.domain.mall.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.gexingw.ddd.core.AggregateRoot;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/10/18 14:10
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MallUser implements AggregateRoot<Long> {

    @Setter
    private Long id;

    private String username;

    private String phone;

    private String password;

}
