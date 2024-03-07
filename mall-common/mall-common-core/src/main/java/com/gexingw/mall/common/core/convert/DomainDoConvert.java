package com.gexingw.mall.common.core.convert;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/7 9:59
 */
public interface DomainDoConvert<Domain, DataObject> {

    DataObject toDO(Domain domain);

    Domain toDomain(DataObject dataObject);

}
