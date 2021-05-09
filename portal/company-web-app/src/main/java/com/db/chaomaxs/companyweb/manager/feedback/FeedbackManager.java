package com.db.chaomaxs.companyweb.manager.feedback;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.facade.FeedbackRpcFacade;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackAddDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPageDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackUpdateDTO;
import com.db.chaomaxs.companyweb.controller.feedback.vo.FeedbackVO;
import com.db.chaomaxs.companyweb.convert.feedback.FeedbackConvert;
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
  private FeedbackRpcFacade feedbackRpcFacade;

  /**
   * 添加数据
   *
   * @param feedbackCreateReqDTO 添加参数
   * @return
   */
  public int save(FeedbackAddDTO feedbackAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = feedbackRpcFacade
        .save(FeedbackConvert.INSTANCE.convert(feedbackAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param feedbackUpdateDTO 更新参数
   * @return
   */
  public int update(FeedbackUpdateDTO feedbackUpdateDTO) {
    BaseResponse baseResponse = feedbackRpcFacade
        .update(FeedbackConvert.INSTANCE.convert(feedbackUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = feedbackRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public FeedbackVO getFeedbackById(Long id) {
    ObjectRestResponse<FeedbackRespDTO> objectRestResponse = feedbackRpcFacade.getFeedbackById(id);
    objectRestResponse.checkError();
    return FeedbackConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param feedbackDTO 查询参数
   * @return
   */
  public List<FeedbackVO> listFeedbacks(FeedbackDTO feedbackDTO) {
    ObjectRestResponse<List<FeedbackRespDTO>> objectRestResponse = feedbackRpcFacade
        .listFeedbacks(FeedbackConvert.INSTANCE.convert(feedbackDTO));
    objectRestResponse.checkError();
    return FeedbackConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<FeedbackVO> pageFeedback(FeedbackPageDTO pageReqDTO) {
    TableResultResponse<FeedbackRespDTO> tableResultResponse = feedbackRpcFacade
        .page(FeedbackConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return FeedbackConvert.INSTANCE.convert(tableResultResponse);
  }


}
