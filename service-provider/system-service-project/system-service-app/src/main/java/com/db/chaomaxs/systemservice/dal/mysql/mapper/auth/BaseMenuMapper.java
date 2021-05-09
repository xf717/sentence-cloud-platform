package com.db.chaomaxs.systemservice.dal.mysql.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseMenuDO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuPageReqDTO;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Repository
public interface BaseMenuMapper extends BaseMapper<BaseMenuDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<BaseMenuDO> selectList(BaseMenuListQueryReqDTO listReqDTO) {
    QueryWrapperX queryWrapper = new QueryWrapperX();
    if (StringUtils.isNotEmpty(listReqDTO.getTitle())) {
      queryWrapper.likeIfPresent("title", listReqDTO.getTitle());
    }
    if (listReqDTO.getParentId() != null) {
      queryWrapper.eqIfPresent("parent_id", listReqDTO.getParentId());
    }
    if (StringUtils.isNotEmpty(listReqDTO.getPath())) {
      queryWrapper.eqIfPresent("path", listReqDTO.getPath());
    }
    return selectList(queryWrapper);
  }

  default List<BaseMenuDO> selectListMenu(String path, Long id) {
    QueryWrapperX queryWrapper = new QueryWrapperX();
    queryWrapper.likeIfPresent("path", path);
    queryWrapper.ne("id", id);
    return selectList(queryWrapper);
  }

  /**
   * 查询全部数据
   *
   * @return
   */
  default List<BaseMenuDO> selectAllList() {
    return selectList(new QueryWrapperX<BaseMenuDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<BaseMenuDO> selectPage(BaseMenuPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<BaseMenuDO>());
  }

  List<BaseMenuDO> selectMenuByAuthorityId(@Param("authorityId") String authorityId,
      @Param("authorityType") String authorityType);

  /**
   * 根据用户和组的权限关系查找用户可访问菜单
   *
   * @param userId
   * @return
   */
  List<BaseMenuDO> selectAuthorityMenuByUserId(@Param("userId") Long userId);

  /**
   * 根据用户和组的权限关系查找用户可访问的系统
   *
   * @param userId
   * @return
   */
  List<BaseMenuDO> selectAuthoritySystemByUserId(@Param("userId") Long userId);


}
