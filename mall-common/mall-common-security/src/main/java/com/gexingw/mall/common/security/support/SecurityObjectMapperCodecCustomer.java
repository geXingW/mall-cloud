package com.gexingw.mall.common.security.support;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.spring.security.jackson.ObjectMapperCodec;
import org.apache.dubbo.spring.security.jackson.ObjectMapperCodecCustomer;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/29 14:58
 */
@Slf4j
public class SecurityObjectMapperCodecCustomer implements ObjectMapperCodecCustomer {

    @Override
    public void customize(ObjectMapperCodec objectMapperCodec) {
        objectMapperCodec.addModule(new SecurityJackson2Module());
    }

}
