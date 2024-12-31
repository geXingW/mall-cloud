package top.gexingw.mall.service.user.infra.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import top.gexingw.mall.service.user.domain.mall.user.MallUser;
import top.gexingw.mall.service.user.domain.mall.user.MallUserRepository;
import top.gexingw.mall.service.user.rpc.auth.AuthUserRPCClient;

@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class MallUserRepositoryImpl implements MallUserRepository {

    private final AuthUserRPCClient authUserRPCClient;

    @Override
    public MallUser findByPhone(String phone) {
        return null;
    }

    @Override
    public @Nullable MallUser find(@NotNull Long aLong) {
        return null;
    }

    @Override
    public @NotNull Boolean remove(@NotNull MallUser mallUser) {
        return false;
    }

    @Override
    public @NotNull Boolean save(@NotNull MallUser mallUser) {
        Long registeredMallUserId = authUserRPCClient.registerUser(mallUser.getPhone(), mallUser.getPassword());
        mallUser.setId(registeredMallUserId);

        return true;
    }

}
