package com.maruko.mall.security.admin.biz;

import com.maruko.mall.common.biz.BaseBiz;
import org.springframework.stereotype.Service;

import com.maruko.mall.security.admin.entity.GroupType;
import com.maruko.mall.security.admin.mapper.GroupTypeMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-12 8:48
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GroupTypeBiz extends BaseBiz<GroupTypeMapper,GroupType> {
}
