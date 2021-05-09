package com.github.xf717.systemservice.dal.mysql.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.systemservice.dal.mysql.dataobject.auth.BaseGroupDO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupPageReqDTO;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Repository
public interface BaseGroupMapper extends BaseMapper<BaseGroupDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<BaseGroupDO> selectList(BaseGroupListQueryReqDTO listReqDTO) {
    QueryWrapperX queryWrapper = new QueryWrapperX();
    if (StringUtils.isNotEmpty(listReqDTO.getName())) {
      queryWrapper.likeIfPresent("name", listReqDTO.getName());
    }
    if (listReqDTO.getGroupType() != null) {
      queryWrapper.eqIfPresent("group_type", listReqDTO.getGroupType());
    }
    return selectList(queryWrapper);
  }

  default IPage<BaseGroupDO> selectPage(BaseGroupPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<BaseGroupDO>());
  }

}
