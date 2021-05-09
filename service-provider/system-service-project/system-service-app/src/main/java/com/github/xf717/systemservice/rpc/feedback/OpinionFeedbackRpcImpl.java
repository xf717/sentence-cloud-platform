package com.github.xf717.systemservice.rpc.feedback;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.feedback.OpinionFeedbackManager;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackCreateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackListQueryReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackPageReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackRespDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackUpdateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.facade.OpinionFeedbackRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Slf4j
@Service
public class OpinionFeedbackRpcImpl implements OpinionFeedbackRpcFacade {

  @Autowired
  private OpinionFeedbackManager opinionFeedbackManager;

  @Override
  public BaseResponse save(OpinionFeedbackCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    opinionFeedbackManager.saveOpinionFeedback(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(OpinionFeedbackUpdateReqDTO updateReqDTO) {
      opinionFeedbackManager.updateOpinionFeedback(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      opinionFeedbackManager.deleteOpinionFeedback(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<OpinionFeedbackRespDTO> getOpinionFeedbackById(Long id) {
      OpinionFeedbackRespDTO opinionFeedback = opinionFeedbackManager.getOpinionFeedbackById(id);
    return new ObjectRestResponse<>().data(opinionFeedback);
  }

  @Override
  public ObjectRestResponse<List<OpinionFeedbackRespDTO>> listOpinionFeedbacks(OpinionFeedbackListQueryReqDTO listQuery) {
    List<OpinionFeedbackRespDTO> list = opinionFeedbackManager.listOpinionFeedbacks(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<OpinionFeedbackRespDTO> page(OpinionFeedbackPageReqDTO pageReqDTO) {
    PageResult<OpinionFeedbackRespDTO> pageResult = opinionFeedbackManager.pageOpinionFeedback(pageReqDTO);
    TableResultResponse<OpinionFeedbackRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }


  @Override
  public ObjectRestResponse<OpinionFeedbackRespDTO> selectLastFeedbackByUserId(OpinionFeedbackListQueryReqDTO listQuery) {
    OpinionFeedbackRespDTO opinionFeedback = opinionFeedbackManager.selectLastFeedbackByUserId(listQuery);
    return new ObjectRestResponse<>().data(opinionFeedback);
  }

}
