package com.gexingw.mall.common.core.convert;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/12 19:36
 */
@SuppressWarnings("unused")
public interface DomainCOConvert<DataObject, ClientObject> {

    ClientObject toCo(DataObject dataObject);

    DataObject toDomain(ClientObject clientObject);

}
