package com.db.chaomaxs.companyservice.manager.feedback;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackUpdateReqDTO;
import com.db.chaomaxs.companyservice.service.feedback.FeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * FeedbackManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class FeedbackManager {

  @Autowired
  private FeedbackService feedbackService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveFeedback(FeedbackCreateReqDTO createReqDTO) {
    return feedbackService.saveFeedback(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateFeedback(FeedbackUpdateReqDTO updateReqDTO) {
    return feedbackService.updateFeedback(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteFeedback(Long id) {
    return feedbackService.deleteFeedback(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<FeedbackRespDTO> listFeedbacks(FeedbackListQueryReqDTO listQueryReqDTO) {
    return feedbackService.listFeedbacks(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public FeedbackRespDTO getFeedbackById(Long id) {
    return feedbackService.getFeedbackById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<FeedbackRespDTO> pageFeedback(FeedbackPageReqDTO page) {
    return feedbackService.pageFeedback(page);
  }


}
