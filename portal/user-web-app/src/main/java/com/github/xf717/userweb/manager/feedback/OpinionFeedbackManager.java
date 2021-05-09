package com.github.xf717.userweb.manager.feedback;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.resourceservice.rpc.resource.dto.ResourceListQueryReqDTO;
import com.github.xf717.resourceservice.rpc.resource.dto.ResourceRespDTO;
import com.github.xf717.resourceservice.rpc.resource.facade.ResourceRpcFacade;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackCreateReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackListQueryReqDTO;
import com.github.xf717.systemservice.rpc.feedback.dto.OpinionFeedbackRespDTO;
import com.github.xf717.systemservice.rpc.feedback.facade.OpinionFeedbackRpcFacade;
import com.github.xf717.userservice.rpc.user.dto.UserExtendRespDTO;
import com.github.xf717.userservice.rpc.user.facade.UserExtendRpcFacade;
import com.github.xf717.userweb.controller.feedback.dto.OpinionFeedbackAddDTO;
import com.github.xf717.userweb.controller.feedback.vo.OpinionFeedbackVO;
import com.github.xf717.userweb.convert.feedback.OpinionFeedbackConvert;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * OpinionFeedbackManager
 *
 * @author ding
 * @date 2021-03-29 18:18:10
 */
@Service
@Validated
public class OpinionFeedbackManager {

  @Autowired
  private OpinionFeedbackRpcFacade opinionFeedbackRpcFacade;
  @Autowired
  private UserExtendRpcFacade userExtendRpcFacade;
  @Autowired
  private ResourceRpcFacade resourceRpcFacade;

  /**
   * 添加数据
   *
   * @param opinionFeedbackAddDTO 添加参数
   * @return
   */
  public int save(OpinionFeedbackAddDTO opinionFeedbackAddDTO) {
    OpinionFeedbackCreateReqDTO reqDTO = OpinionFeedbackConvert.INSTANCE
        .convert(opinionFeedbackAddDTO);
    ObjectRestResponse<UserExtendRespDTO> userExtend = userExtendRpcFacade
        .getUserExtendByUserId(BaseContextHandler.getUserId());
    if (null != userExtend.getData()) {
      reqDTO.setFeedbackName(userExtend.getData().getRealName());
    }
    reqDTO.setFeedbackBy(BaseContextHandler.getUserId());
    reqDTO.setMobile(BaseContextHandler.getUsername());
    reqDTO.setReleaseTime(new Date());
    BaseResponse baseResponse = opinionFeedbackRpcFacade
        .save(reqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据userid查询数据第一条数据
   *
   * @param
   * @return
   */
  public OpinionFeedbackVO userLastFeedback() {
    OpinionFeedbackListQueryReqDTO listQuery = new OpinionFeedbackListQueryReqDTO();
    listQuery.setFeedbackBy(BaseContextHandler.getUserId());
    ObjectRestResponse<OpinionFeedbackRespDTO> response = opinionFeedbackRpcFacade
        .selectLastFeedbackByUserId(listQuery);
    response.checkError();
    if (null != response.getData()) {
      //取第一条数据返回app前端
      OpinionFeedbackRespDTO respDTO = response.getData();
      OpinionFeedbackVO feedbackVO = OpinionFeedbackConvert.INSTANCE.convert(respDTO);
      if (!CollectionUtils.isEmpty(respDTO.getImgs())) {
        Set<Long> ids = new HashSet<>();
        ids.addAll(respDTO.getImgs());
        feedbackVO.setImgUrls(toUrls(ids));
      }
      return feedbackVO;
    }

    return new OpinionFeedbackVO();
  }


  /**
   * 返回fileUrl集合
   *
   * @param ids
   * @return
   */
  public List<String> toUrls(Set<Long> ids) {
    ResourceListQueryReqDTO listQuery = new ResourceListQueryReqDTO();
    listQuery.setIds(ids);
    ObjectRestResponse<List<ResourceRespDTO>> resourceResponse = resourceRpcFacade
        .listResources(listQuery);
    List<String> urls = resourceResponse.getData().stream()
        .filter(r -> null != r.getFileUrl())
        .map(ResourceRespDTO::getFileUrl).collect(Collectors.toList());
    return urls;
  }


}
