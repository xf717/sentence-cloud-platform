package com.db.chaomaxs.positionservice.dal.mysql.mapper.positiontype;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.positiontype.PositionKeywordDO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 内容管理-职位关键词信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Repository
public interface PositionKeywordMapper extends BaseMapper<PositionKeywordDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<PositionKeywordDO> selectList(PositionKeywordListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<PositionKeywordDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<PositionKeywordDO> selectPage(PositionKeywordPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<PositionKeywordDO>());
  }

}
