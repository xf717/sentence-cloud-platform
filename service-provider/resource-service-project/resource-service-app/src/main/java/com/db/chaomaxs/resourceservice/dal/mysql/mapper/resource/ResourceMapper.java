package com.db.chaomaxs.resourceservice.dal.mysql.mapper.resource;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.resourceservice.dal.mysql.dataobject.resource.ResourceDO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceListQueryReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourcePageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 文件资源表
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Repository
public interface ResourceMapper extends BaseMapper<ResourceDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<ResourceDO> selectList(ResourceListQueryReqDTO listReqDTO) {
    LambdaQueryWrapper<ResourceDO> queryWrapper = Wrappers.lambdaQuery();
    if (!CollectionUtils.isEmpty(listReqDTO.getIds())) {
      queryWrapper.in(ResourceDO::getId, listReqDTO.getIds());
    }
    return selectList(queryWrapper);
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<ResourceDO> selectPage(ResourcePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<ResourceDO>());
  }

}
