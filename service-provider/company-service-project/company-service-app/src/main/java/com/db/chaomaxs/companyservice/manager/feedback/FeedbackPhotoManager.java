package com.db.chaomaxs.companyservice.manager.feedback;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoUpdateReqDTO;
import com.db.chaomaxs.companyservice.service.feedback.FeedbackPhotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * FeedbackPhotoManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class FeedbackPhotoManager {

  @Autowired
  private FeedbackPhotoService feedbackPhotoService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveFeedbackPhoto(FeedbackPhotoCreateReqDTO createReqDTO) {
    return feedbackPhotoService.saveFeedbackPhoto(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateFeedbackPhoto(FeedbackPhotoUpdateReqDTO updateReqDTO) {
    return feedbackPhotoService.updateFeedbackPhoto(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteFeedbackPhoto(Long id) {
    return feedbackPhotoService.deleteFeedbackPhoto(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<FeedbackPhotoRespDTO> listFeedbackPhotos(
      FeedbackPhotoListQueryReqDTO listQueryReqDTO) {
    return feedbackPhotoService.listFeedbackPhotos(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public FeedbackPhotoRespDTO getFeedbackPhotoById(Long id) {
    return feedbackPhotoService.getFeedbackPhotoById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<FeedbackPhotoRespDTO> pageFeedbackPhoto(FeedbackPhotoPageReqDTO page) {
    return feedbackPhotoService.pageFeedbackPhoto(page);
  }


}
