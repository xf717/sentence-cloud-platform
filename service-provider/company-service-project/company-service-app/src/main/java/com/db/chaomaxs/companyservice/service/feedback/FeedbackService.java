package com.db.chaomaxs.companyservice.service.feedback;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.convert.feedback.FeedbackConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.feedback.FeedbackDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.feedback.FeedbackMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * FeedbackService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class FeedbackService {

  @Autowired
  private FeedbackMapper feedbackMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveFeedback(FeedbackCreateReqDTO createReqDTO) {
    return feedbackMapper.insert(FeedbackConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateFeedback(FeedbackUpdateReqDTO updateReqDTO) {
    FeedbackDO feedbackDO = feedbackMapper.selectById(updateReqDTO.getId());
    if (feedbackDO == null) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    feedbackDO = FeedbackConvert.INSTANCE.convert(updateReqDTO);
    int result = feedbackMapper.updateById(feedbackDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteFeedback(Long id) {
    if (feedbackMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = feedbackMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<FeedbackRespDTO> listFeedbacks(FeedbackListQueryReqDTO listQueryReqDTO) {
    List<FeedbackDO> list = feedbackMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return FeedbackConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public FeedbackRespDTO getFeedbackById(Long id) {
    FeedbackDO feedbackDO = feedbackMapper.selectById(id);
    if (feedbackDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return FeedbackConvert.INSTANCE.convert(feedbackDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<FeedbackRespDTO> pageFeedback(FeedbackPageReqDTO page) {
    IPage<FeedbackDO> feedbackPage = feedbackMapper.selectPage(page);
    return FeedbackConvert.INSTANCE.convertPage(feedbackPage);
  }


}
