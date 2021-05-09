package com.db.chaomaxs.companyservice.rpc.feedback;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.manager.feedback.FeedbackPhotoManager;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.dto.FeedbackPhotoUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.feedback.facade.FeedbackPhotoRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FeedbackPhotoRpcImpl implements FeedbackPhotoRpcFacade {

  @Autowired
  private FeedbackPhotoManager feedbackPhotoManager;

  @Override
  public BaseResponse save(FeedbackPhotoCreateReqDTO feedbackPhotoCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    feedbackPhotoManager.saveFeedbackPhoto(feedbackPhotoCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(FeedbackPhotoUpdateReqDTO feedbackPhotoUpdateReqDTO) {
    return null;
  }

  @Override
  public BaseResponse remove(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<FeedbackPhotoRespDTO> getFeedbackPhotoById(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<List<FeedbackPhotoRespDTO>> listFeedbackPhotos(
      FeedbackPhotoListQueryReqDTO listQuery) {
    return null;
  }

  @Override
  public TableResultResponse<FeedbackPhotoRespDTO> page(FeedbackPhotoPageReqDTO pageReqDTO) {
    PageResult<FeedbackPhotoRespDTO> pageResult = feedbackPhotoManager.pageFeedbackPhoto(pageReqDTO);
    TableResultResponse<FeedbackPhotoRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
