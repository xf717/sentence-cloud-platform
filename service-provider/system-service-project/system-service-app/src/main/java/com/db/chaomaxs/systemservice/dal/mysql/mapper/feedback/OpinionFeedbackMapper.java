package com.db.chaomaxs.systemservice.dal.mysql.mapper.feedback;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.feedback.OpinionFeedbackDO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackPageReqDTO;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Repository
public interface OpinionFeedbackMapper extends BaseMapper<OpinionFeedbackDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<OpinionFeedbackDO> selectList(OpinionFeedbackListQueryReqDTO listReqDTO) {
    LambdaQueryWrapper<OpinionFeedbackDO> queryWrapper = Wrappers.lambdaQuery();
    if (null != listReqDTO.getFeedbackBy()) {
      queryWrapper.eq(OpinionFeedbackDO::getFeedbackBy, listReqDTO.getFeedbackBy());
    }
    queryWrapper.orderByDesc(OpinionFeedbackDO::getId);
    return selectList(queryWrapper);
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<OpinionFeedbackDO> selectPage(OpinionFeedbackPageReqDTO pageReqDTO) {
    LambdaQueryWrapper<OpinionFeedbackDO> queryWrapper = Wrappers.lambdaQuery();
    if (null != pageReqDTO.getFeedbackBy()) {
      queryWrapper.eq(OpinionFeedbackDO::getFeedbackBy, pageReqDTO.getFeedbackBy());
    }
    if (StringUtils.isNotBlank(pageReqDTO.getFeedbackContent())) {
      queryWrapper.like(OpinionFeedbackDO::getFeedbackContent, pageReqDTO.getFeedbackContent());
    }
    if (StringUtils.isNotBlank(pageReqDTO.getFeedbackName())) {
      queryWrapper.like(OpinionFeedbackDO::getFeedbackName, pageReqDTO.getFeedbackName());
    }
    if (StringUtils.isNotBlank(pageReqDTO.getMobile())) {
      queryWrapper.like(OpinionFeedbackDO::getMobile, pageReqDTO.getMobile());
    }
    if (null != pageReqDTO.getHandleStatus()) {
      queryWrapper.eq(OpinionFeedbackDO::getHandleStatus, pageReqDTO.getHandleStatus());
    }
    if (null != pageReqDTO.getReleasePlatformType()) {
      queryWrapper
          .eq(OpinionFeedbackDO::getReleasePlatformType, pageReqDTO.getReleasePlatformType());
    }

    if (null != pageReqDTO.getReleaseStartTime() && null == pageReqDTO.getReleaseEndTime()) {
      queryWrapper
          .between(OpinionFeedbackDO::getReleaseTime, pageReqDTO.getReleaseStartTime(), new Date());
    }
    if (null != pageReqDTO.getReleaseEndTime() && null == pageReqDTO.getReleaseStartTime()) {
      queryWrapper
          .between(OpinionFeedbackDO::getReleaseTime, new Date(0), pageReqDTO.getReleaseEndTime());
    }

    if (null != pageReqDTO.getReleaseStartTime() && null != pageReqDTO.getReleaseEndTime()) {
      queryWrapper
          .between(OpinionFeedbackDO::getReleaseTime, pageReqDTO.getReleaseStartTime(),
              pageReqDTO.getReleaseEndTime());
    }

    if (null != pageReqDTO.getEditStartTime() && null == pageReqDTO.getEditEndTime()) {
      queryWrapper
          .between(OpinionFeedbackDO::getUpdateTime, pageReqDTO.getEditStartTime(), new Date());
    }
    if (null != pageReqDTO.getEditEndTime() && null == pageReqDTO.getEditStartTime()) {
      queryWrapper
          .between(OpinionFeedbackDO::getUpdateTime, new Date(0), pageReqDTO.getEditEndTime());
    }

    if (null != pageReqDTO.getEditStartTime() && null != pageReqDTO.getEditEndTime()) {
      queryWrapper
          .between(OpinionFeedbackDO::getUpdateTime, pageReqDTO.getEditStartTime(),
              pageReqDTO.getEditEndTime());
    }
    queryWrapper.orderByDesc(OpinionFeedbackDO::getUpdateTime, OpinionFeedbackDO::getId);

    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
  }


  /**
   * 根据userId获取最后一条反馈记录
   *
   * @param listReqDTO
   * @return
   */
  default OpinionFeedbackDO selectLastFeedbackByUserId(OpinionFeedbackListQueryReqDTO listReqDTO) {
    LambdaQueryWrapper<OpinionFeedbackDO> queryWrapper = Wrappers.lambdaQuery();
    if (null != listReqDTO.getFeedbackBy()) {
      queryWrapper.eq(OpinionFeedbackDO::getFeedbackBy, listReqDTO.getFeedbackBy());
    }
    queryWrapper.orderByDesc(OpinionFeedbackDO::getId);
    queryWrapper.last("limit 1");
    return selectOne(queryWrapper);
  }

}
