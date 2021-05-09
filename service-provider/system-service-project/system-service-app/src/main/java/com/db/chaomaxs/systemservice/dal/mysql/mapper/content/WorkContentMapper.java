package com.db.chaomaxs.systemservice.dal.mysql.mapper.content;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.content.WorkContentDO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 内容管理-工作内容息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Repository
public interface WorkContentMapper extends BaseMapper<WorkContentDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<WorkContentDO> selectList(WorkContentListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<WorkContentDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<WorkContentDO> selectPage(WorkContentPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<WorkContentDO>());
  }

  /**
   * 获取内容最大id值
   * @return
   */
  Long selectMaxWorkContentId();

}
