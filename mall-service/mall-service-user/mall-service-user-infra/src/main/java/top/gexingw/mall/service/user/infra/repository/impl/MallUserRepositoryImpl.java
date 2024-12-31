package top.gexingw.mall.service.user.infra.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import top.gexingw.mall.service.user.dao.mall.user.MallUserMapper;
import top.gexingw.mall.service.user.dao.mall.user.MallUserPO;
import top.gexingw.mall.service.user.domain.mall.user.MallUser;
import top.gexingw.mall.service.user.domain.mall.user.MallUserRepository;
import top.gexingw.mall.service.user.infra.convert.MallUserConvert;
import top.gexingw.mall.service.user.rpc.auth.AuthUserRPCClient;

@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class MallUserRepositoryImpl implements MallUserRepository {

    private final AuthUserRPCClient authUserRPCClient;

    private final MallUserMapper mallUserMapper;

    private final MallUserConvert mallUserConvert;

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
        // 生成Auth User
        Long registeredMallUserId = authUserRPCClient.registerUser(mallUser.getPhone(), mallUser.getPassword());
        mallUser.registered(registeredMallUserId);

        // 生成Mall User
        MallUserPO mallUserPO = mallUserConvert.toPO(mallUser);
        this.mallUserMapper.insert(mallUserPO);

        return true;
    }

}
