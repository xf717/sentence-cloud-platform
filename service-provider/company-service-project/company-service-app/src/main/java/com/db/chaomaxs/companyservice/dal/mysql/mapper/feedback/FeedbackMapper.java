package com.db.chaomaxs.companyservice.dal.mysql.mapper.feedback;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.feedback.FeedbackDO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPageReqDTO;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 帮助与反馈
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Repository
public interface FeedbackMapper extends BaseMapper<FeedbackDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<FeedbackDO> selectList(FeedbackListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<FeedbackDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<FeedbackDO> selectPage(FeedbackPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<FeedbackDO>());
  }

}
