package com.gexingw.mall.common.db.support;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/26 16:05
 */
public class MyBatisPlusService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

}
