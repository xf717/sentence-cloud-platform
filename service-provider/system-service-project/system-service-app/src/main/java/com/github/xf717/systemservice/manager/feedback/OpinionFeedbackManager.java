package com.github.xf717.systemservice.manager.feedback;

import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackCreateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackListQueryReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackPageReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackRespDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackUpdateReqDTO;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.service.feedback.OpinionFeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * OpinionFeedbackManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Service
@Validated
public class OpinionFeedbackManager {

  @Autowired
  private OpinionFeedbackService opinionFeedbackService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveOpinionFeedback(OpinionFeedbackCreateReqDTO createReqDTO) {
    return opinionFeedbackService.saveOpinionFeedback(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateOpinionFeedback(OpinionFeedbackUpdateReqDTO updateReqDTO) {
      return opinionFeedbackService.updateOpinionFeedback(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteOpinionFeedback(Long id) {
    return opinionFeedbackService.deleteOpinionFeedback(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<OpinionFeedbackRespDTO> listOpinionFeedbacks(OpinionFeedbackListQueryReqDTO listQueryReqDTO) {
    return opinionFeedbackService.listOpinionFeedbacks(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public OpinionFeedbackRespDTO getOpinionFeedbackById(Long id) {
    return opinionFeedbackService.getOpinionFeedbackById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<OpinionFeedbackRespDTO> pageOpinionFeedback(OpinionFeedbackPageReqDTO page) {
    return opinionFeedbackService.pageOpinionFeedback(page);
  }

  /**
   * 根据userId获取最后一条反馈记录
   * @param listQueryReqDTO
   * @return
   */
  public OpinionFeedbackRespDTO selectLastFeedbackByUserId(OpinionFeedbackListQueryReqDTO listQueryReqDTO) {
    return opinionFeedbackService.selectLastFeedbackByUserId(listQueryReqDTO);
  }


}
