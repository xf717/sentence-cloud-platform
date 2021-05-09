package com.github.xf717.systemservice.dal.mysql.mapper.content;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.WorkContentExtendDO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 内容管理-工作内容_扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Repository
public interface WorkContentExtendMapper extends BaseMapper<WorkContentExtendDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<WorkContentExtendDO> selectList(WorkContentExtendListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<WorkContentExtendDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<WorkContentExtendDO> selectPage(WorkContentExtendPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<WorkContentExtendDO>());
  }

  /**
   * 根据内容id 查询
   * @param contentId
   * @return
   */
  WorkContentExtendDO getWorkContentExtendByContentId(@Param("contentId")Long contentId);

}
