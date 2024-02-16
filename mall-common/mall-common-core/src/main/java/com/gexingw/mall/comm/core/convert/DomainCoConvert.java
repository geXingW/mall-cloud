package com.gexingw.mall.comm.core.convert;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/12 19:36
 */
@SuppressWarnings("unused")
public interface DomainCoConvert<DataObject, ClientObject> {

    ClientObject toCo(DataObject dataObject);

    DataObject toDomain(ClientObject clientObject);

}
