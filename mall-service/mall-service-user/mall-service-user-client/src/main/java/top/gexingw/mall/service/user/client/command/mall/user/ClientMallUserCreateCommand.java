package top.gexingw.mall.service.user.client.command.mall.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/19 14:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ClientMallUserCreateCommand {

    private String username;

    private String phone;

    private String password;

}
