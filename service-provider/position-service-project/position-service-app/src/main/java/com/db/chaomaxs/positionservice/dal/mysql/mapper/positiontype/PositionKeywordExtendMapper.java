package com.db.chaomaxs.positionservice.dal.mysql.mapper.positiontype;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.positiontype.PositionKeywordExtendDO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 职务关键词-扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Repository
public interface PositionKeywordExtendMapper extends BaseMapper<PositionKeywordExtendDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<PositionKeywordExtendDO> selectList(PositionKeywordExtendListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<PositionKeywordExtendDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<PositionKeywordExtendDO> selectPage(PositionKeywordExtendPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<PositionKeywordExtendDO>());
  }

}
