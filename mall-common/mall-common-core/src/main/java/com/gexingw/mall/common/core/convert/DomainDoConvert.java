package com.gexingw.mall.common.core.convert;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/7 9:59
 */
@SuppressWarnings("unused")
public interface DomainDoConvert<Domain, PO> {

    PO toPO(Domain domain);

    Domain toDomain(PO po);

}
