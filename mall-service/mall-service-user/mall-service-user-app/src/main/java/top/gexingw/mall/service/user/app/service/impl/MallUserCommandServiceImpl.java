package top.gexingw.mall.service.user.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import top.gexingw.mall.service.user.app.service.MallUserCommandService;
import top.gexingw.mall.service.user.app.service.MallUserQueryService;
import top.gexingw.mall.service.user.client.co.mall.user.MallUserAuthTokenCO;
import top.gexingw.mall.service.user.client.command.mall.user.ClientMallUserCreateCommand;
import top.gexingw.mall.service.user.dao.mall.user.MallUserMapper;
import top.gexingw.mall.service.user.dao.mall.user.MallUserPO;
import top.gexingw.mall.service.user.domain.mall.auth.AuthToken;
import top.gexingw.mall.service.user.domain.mall.user.MallUser;
import top.gexingw.mall.service.user.domain.mall.user.MallUserFactory;
import top.gexingw.mall.service.user.domain.mall.user.MallUserRepository;
import top.gexingw.mall.service.user.rpc.auth.AuthUserRPCClient;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/19 16:31
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class MallUserCommandServiceImpl implements MallUserCommandService {

    private final MallUserRepository mallUserRepository;

    private final MallUserMapper mallUserMapper;

    private final MallUserQueryService mallUserQueryService;

    private final AuthUserRPCClient authUserRPCClient;


    /**
     * Creates a new user and saves it to the database.
     *
     * @param command {@link ClientMallUserCreateCommand}
     * @return The ID of the newly created user
     */
    @Override
    public Long create(ClientMallUserCreateCommand command) {
        // Check if the phone number already exists
        LambdaQueryWrapper<MallUserPO> queryWrapper = new LambdaQueryWrapper<MallUserPO>().eq(MallUserPO::getPhone, command.getPhone());
        Long phoneExistCount = mallUserMapper.selectCount(queryWrapper);
        if (phoneExistCount > 0) {
            throw new RuntimeException(" ");
        }

        // Create the user
        MallUser mallUser = MallUserFactory.create(command.getPhone(), command.getPassword());

        // Save the user to the database
        if (!mallUserRepository.save(mallUser)) {
            throw new RuntimeException("用户创建失败！");
        }

        return mallUser.getId();
    }

    @Override
    public @NotNull MallUserAuthTokenCO login(String phone, String password) {
        // 根据手机号检查MallUser是否存在
        MallUser mallUser = mallUserRepository.findByPhone(phone);
        if (mallUser != null) {
            AuthToken authToken = authUserRPCClient.loginUser(phone, password);
            return new MallUserAuthTokenCO(authToken.getAccessToken(), authToken.getRefreshToken(), authToken.getTokenType(), authToken.getScope(), authToken.getExpiresIn());
        }

        return new MallUserAuthTokenCO("", "", "", "", 1L);
    }

}
