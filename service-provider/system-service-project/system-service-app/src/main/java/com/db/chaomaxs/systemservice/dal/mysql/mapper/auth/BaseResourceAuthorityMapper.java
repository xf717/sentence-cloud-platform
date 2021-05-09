package com.db.chaomaxs.systemservice.dal.mysql.mapper.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.mapper.CommonMapper;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseResourceAuthorityDO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseResourceAuthorityListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseResourceAuthorityPageReqDTO;
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
public interface BaseResourceAuthorityMapper extends CommonMapper<BaseResourceAuthorityDO> {

  default List<BaseResourceAuthorityDO> selectList(
      BaseResourceAuthorityListQueryReqDTO listReqDTO) {
    QueryWrapperX<BaseResourceAuthorityDO> queryWrapper = new QueryWrapperX();
    if (StringUtils.isNotEmpty(listReqDTO.getAuthorityType())) {
      queryWrapper.eqIfPresent("authority_type", listReqDTO.getAuthorityType());
    }
    if (StringUtils.isNotEmpty(listReqDTO.getResourceType())) {
      queryWrapper.eqIfPresent("resource_type", listReqDTO.getResourceType());
    }
    if (listReqDTO.getAuthorityId() != null) {
      queryWrapper.eqIfPresent("authority_id", listReqDTO.getAuthorityId());
    }
    return selectList(queryWrapper);
  }

  default IPage<BaseResourceAuthorityDO> selectPage(BaseResourceAuthorityPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<BaseResourceAuthorityDO>());
  }

  /**
   * 根据数权限id 和 资源类型删除数据
   *
   * @param authorityId
   * @param resourceType
   */
  @Delete("DELETE FROM base_resource_authority WHERE authority_id = #{authorityId} and resource_type = #{resourceType}")
  void removeByAuthorityIdAndResourceType(@Param("authorityId") String authorityId,
      @Param("resourceType") String resourceType);

  /**
   * 删除权限资源
   *
   * @param groupId
   * @param elementId
   * @param parentId
   */
  default void removeAuthorityElement(Long groupId, Long elementId, Long parentId) {
    QueryWrapperX<BaseResourceAuthorityDO> queryWrapper = new QueryWrapperX();
    queryWrapper.eqIfPresent("authority_id", groupId);
    queryWrapper.eqIfPresent("resource_id", elementId);
    queryWrapper.eqIfPresent("parent_id", parentId);
    this.delete(queryWrapper);
  }


}
