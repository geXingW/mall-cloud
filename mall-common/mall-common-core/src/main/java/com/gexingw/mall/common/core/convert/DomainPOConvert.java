package com.gexingw.mall.common.core.convert;

/**
 * @author GeXingW
 */
public interface DomainPOConvert<Domain, PO> {

    PO toPO(Domain domain);

    Domain toDomain(PO po);

}
