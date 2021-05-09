package com.github.xf717.systemservice.rpc.feedback;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.feedback.OpinionFeedbackImageManager;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImageCreateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImageListQueryReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImagePageReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImageRespDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackImageUpdateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.facade.OpinionFeedbackImageRpcFacade;
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
public class OpinionFeedbackImageRpcImpl implements OpinionFeedbackImageRpcFacade {

  @Autowired
  private OpinionFeedbackImageManager opinionFeedbackImageManager;

  @Override
  public BaseResponse save(OpinionFeedbackImageCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    opinionFeedbackImageManager.saveOpinionFeedbackImage(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(OpinionFeedbackImageUpdateReqDTO updateReqDTO) {
      opinionFeedbackImageManager.updateOpinionFeedbackImage(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      opinionFeedbackImageManager.deleteOpinionFeedbackImage(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<OpinionFeedbackImageRespDTO> getOpinionFeedbackImageById(Long id) {
      OpinionFeedbackImageRespDTO opinionFeedbackImage = opinionFeedbackImageManager.getOpinionFeedbackImageById(id);
    return new ObjectRestResponse<>().data(opinionFeedbackImage);
  }

  @Override
  public ObjectRestResponse<List<OpinionFeedbackImageRespDTO>> listOpinionFeedbackImages(OpinionFeedbackImageListQueryReqDTO listQuery) {
    List<OpinionFeedbackImageRespDTO> list = opinionFeedbackImageManager.listOpinionFeedbackImages(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<OpinionFeedbackImageRespDTO> page(OpinionFeedbackImagePageReqDTO pageReqDTO) {
    PageResult<OpinionFeedbackImageRespDTO> pageResult = opinionFeedbackImageManager.pageOpinionFeedbackImage(pageReqDTO);
    TableResultResponse<OpinionFeedbackImageRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
