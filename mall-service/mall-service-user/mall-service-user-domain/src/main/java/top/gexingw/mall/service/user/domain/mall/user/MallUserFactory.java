package top.gexingw.mall.service.user.domain.mall.user;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/19 16:45
 */
public class MallUserFactory {

    public static MallUser create(String phone, String password) {
        return new MallUser(null, phone, phone, password);
    }

}
