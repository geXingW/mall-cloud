package com.gexingw.mall.common.security.support;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.gexingw.mall.common.core.util.JsonUtil;

import java.io.IOException;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/29 15:08
 */
public class SecurityJackson2Module extends SimpleModule {
    public SecurityJackson2Module() {
        super(SecurityJackson2Module.class.getName(), new Version(1, 0, 0, null, null, null));
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(AuthInfo.class, AuthInfoMixin.class);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = AuthInfo.class, name = "AuthInfo"),
            @JsonSubTypes.Type(value = AuthInfo.User.class, name = "authUser"),
            @JsonSubTypes.Type(value = AuthInfo.Client.class, name = "client")
    })
    @JsonDeserialize(using = AuthInfoDeserializer.class)
    public static class AuthInfoMixin {

    }

    public static class AuthInfoDeserializer extends JsonDeserializer<AuthInfo> {

        public static final TypeReference<Long> LONG_TYPE_REFERENCE = new TypeReference<Long>() {
        };

        @Override
        public AuthInfo deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            ObjectMapper objectMapper = (ObjectMapper) jsonParser.getCodec();
            JsonNode treeNode = objectMapper.readTree(jsonParser);

            AuthInfo authInfo = new AuthInfo();
            authInfo.setId(JsonUtil.findValue(treeNode, "id", LONG_TYPE_REFERENCE, objectMapper));

            TypeReference<AuthInfo.User> userTypeReference = new TypeReference<AuthInfo.User>() {
            };
            authInfo.setAuthUser(JsonUtil.findValue(treeNode, "authUser", userTypeReference, objectMapper));

            TypeReference<AuthInfo.Client> clientTypeReference = new TypeReference<AuthInfo.Client>() {
            };
            authInfo.setClient(JsonUtil.findValue(treeNode, "client", clientTypeReference, objectMapper));

            return authInfo;
        }
    }

}
