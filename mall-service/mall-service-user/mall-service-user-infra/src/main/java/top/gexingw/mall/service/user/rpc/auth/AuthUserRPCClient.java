package top.gexingw.mall.service.user.rpc.auth;

import com.gexingw.mall.auth.client.command.PasswordLoginCommand;
import com.gexingw.mall.auth.client.command.user.UserRegisterCommand;
import com.gexingw.mall.auth.client.dubbo.AuthUserDubboService;
import com.gexingw.mall.common.core.util.JacksonUtils;
import com.gexingw.mall.common.core.util.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import top.gexingw.mall.service.user.domain.mall.auth.AuthToken;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthUserRPCClient {

    private final AuthClientConfig authClientConfig;

    @DubboReference
    private AuthUserDubboService authUserDubboService;

    /**
     * 注册用户
     *
     * @param phone    手机号
     * @param password 密码
     * @return 新用户Id
     */
    public Long registerUser(String phone, String password) {
        R<Long> registerResult = authUserDubboService.register(new UserRegisterCommand(phone, password, phone));
        if (!registerResult.isSuccess()) {
            throw new RuntimeException("注册失败！");
        }

        return registerResult.getData();
    }

    public AuthToken loginUser(String phone, String password) {
        // 调用认证授权中心，获取Token信息
        PasswordLoginCommand authLoginCommand = new PasswordLoginCommand();
        authLoginCommand.withClient(authClientConfig.getMall().getClientId(), authClientConfig.getMall().getClientSecret());
        authLoginCommand.withCredential(phone, password);


        try (CloseableHttpClient httpClient = HttpClients.custom().build()) {
            ClassicHttpRequest httpRequest = ClassicRequestBuilder.create("post").setUri("http://mall-cloud-auth/oauth2/token")
                    .setEntity(JacksonUtils.toJson(authLoginCommand)).build();
            CloseableHttpResponse httpResponse = httpClient.execute(httpRequest);
            return JacksonUtils.toObj(httpResponse.getEntity().getContent(), AuthToken.class);

//            httpClient.execute("http://mall-cloud-auth/oauth2/token", authLoginCommand)
        } catch (Exception e) {
            log.error("请求异常！", e);
            throw new RuntimeException("登录失败！");
        }

        // 根据服务名进行调用认证服务
//        TokenInfoCO tokenInfoCO = HttpRequestUtil.postJson("http://mall-cloud-auth/oauth2/token", authLoginCommand, TokenInfoCO.class);
//        if (tokenInfoCO == null) {
//            throw new RuntimeException("登录失败！");
//        }
//
//        return new AuthToken(
//                tokenInfoCO.getAccessToken(), tokenInfoCO.getRefreshToken(), tokenInfoCO.getTokenType(), tokenInfoCO.getScope()
//                , tokenInfoCO.getExpiresIn()
//        );
    }

    public static class AuthTokenResponseHandler implements HttpClientResponseHandler<AuthToken> {
        @Override
        public AuthToken handleResponse(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException {
            return JacksonUtils.toObj(classicHttpResponse.getEntity().getContent(), AuthToken.class);
        }

    }

}
