package com.maruko.mall.security.admin.biz;

import com.maruko.mall.common.biz.BaseBiz;
import com.maruko.mall.security.admin.entity.ResourceAuthority;
import com.maruko.mall.security.admin.mapper.ResourceAuthorityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ace on 2017/6/19.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceAuthorityBiz extends BaseBiz<ResourceAuthorityMapper,ResourceAuthority> {
}
