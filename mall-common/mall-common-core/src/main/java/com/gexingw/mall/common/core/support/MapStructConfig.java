package com.gexingw.mall.common.core.support;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/14 12:35
 */
@MapperConfig(
        uses = ValueObjectMapper.class, // 使用自定义转换器
        componentModel = "default", // 组件模型
        unmappedTargetPolicy = ReportingPolicy.IGNORE, // 忽略未映射的目标属性
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG // 自动继承映射策略
)
public interface MapStructConfig {

}
