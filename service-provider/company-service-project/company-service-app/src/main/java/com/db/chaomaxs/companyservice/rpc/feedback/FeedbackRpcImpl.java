package com.db.chaomaxs.companyservice.rpc.feedback;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.manager.feedback.FeedbackManager;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.facade.FeedbackRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FeedbackRpcImpl implements FeedbackRpcFacade {

  @Autowired
  private FeedbackManager feedbackManager;

  @Override
  public BaseResponse save(FeedbackCreateReqDTO feedbackCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    feedbackManager.saveFeedback(feedbackCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(FeedbackUpdateReqDTO feedbackUpdateReqDTO) {
    return null;
  }

  @Override
  public BaseResponse remove(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<FeedbackRespDTO> getFeedbackById(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<List<FeedbackRespDTO>> listFeedbacks(FeedbackListQueryReqDTO listQuery) {
    return null;
  }

  @Override
  public TableResultResponse<FeedbackRespDTO> page(FeedbackPageReqDTO pageReqDTO) {
    PageResult<FeedbackRespDTO> pageResult = feedbackManager.pageFeedback(pageReqDTO);
    TableResultResponse<FeedbackRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
