package com.db.chaomaxs.systemservice.dal.mysql.mapper.feedback;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.mapper.CommonMapper;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.feedback.OpinionFeedbackImageDO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImageListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackImagePageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 意见反馈_图片
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Repository
public interface OpinionFeedbackImageMapper extends CommonMapper<OpinionFeedbackImageDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<OpinionFeedbackImageDO> selectList(OpinionFeedbackImageListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<OpinionFeedbackImageDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<OpinionFeedbackImageDO> selectPage(OpinionFeedbackImagePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<OpinionFeedbackImageDO>());
  }

  /**
   * 根据opinionFeedbackId删除数据
   *
   * @param opinionFeedbackId
   * @return
   */
  int deleteByOpinionFeedbackId(@Param("opinionFeedbackId") Long opinionFeedbackId);

  /**
   * 根据opinionFeedbackId查询数据
   *
   * @param opinionFeedbackIds
   * @return
   */
  default List<OpinionFeedbackImageDO> listByOpinionFeedbackIds(List<Long> opinionFeedbackIds) {
    LambdaQueryWrapper<OpinionFeedbackImageDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.in(OpinionFeedbackImageDO::getOpinionFeedbackId, opinionFeedbackIds);
    return selectList(queryWrapper);
  }

  /**
   * 批量插入
   * @param list
   * @return
   */
  int insertBatch(@Param("list") List<OpinionFeedbackImageDO> list);

}
