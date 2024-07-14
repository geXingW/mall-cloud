package com.gexingw.mall.user.infra.config;

import org.mapstruct.MapperConfig;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/14 12:50
 */
@SuppressWarnings("DefaultAnnotationParam")
@MapperConfig(
        uses = {
                NicknameMapping.class
        },
        componentModel = "default",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        mappingInheritanceStrategy = org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG
)
public interface MapStructConfig {

}
