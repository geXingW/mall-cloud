package com.gexingw.mall.common.db.support;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gexingw.mall.common.core.domain.AggregationRoot;
import com.gexingw.mall.common.core.support.Repository;
import com.gexingw.mall.common.db.mapper.BaseMapper;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/12 23:11
 */
public abstract class MyBatisRepository<T extends AggregationRoot<ID>, ID extends Serializable, M extends BaseMapper<E>, E extends BasePO> extends ServiceImpl<M, E> implements Repository<T, ID> {

}
