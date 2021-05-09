package com.db.chaomaxs.managementweb.manager.feedback;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.managementweb.controller.feedback.dto.OpinionFeedbackAddDTO;
import com.db.chaomaxs.managementweb.controller.feedback.dto.OpinionFeedbackPageDTO;
import com.db.chaomaxs.managementweb.controller.feedback.dto.OpinionFeedbackUpdateDTO;
import com.db.chaomaxs.managementweb.controller.feedback.vo.OpinionFeedbackVO;
import com.db.chaomaxs.managementweb.convert.feedback.OpinionFeedbackConvert;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceListQueryReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceRespDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.facade.ResourceRpcFacade;
import com.db.chaomaxs.systemservice.enums.opinionfeedback.HandleStatusEnum;
import com.db.chaomaxs.systemservice.enums.opinionfeedback.ReleasePlatformTypeEnum;
import com.db.chaomaxs.systemservice.rpc.feedback.dto.OpinionFeedbackRespDTO;
import com.db.chaomaxs.systemservice.rpc.feedback.facade.OpinionFeedbackRpcFacade;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserExtendRpcFacade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
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
    if (StringUtils.isBlank(opinionFeedbackAddDTO.getFeedbackName())) {
      ObjectRestResponse<UserExtendRespDTO> userExtend = userExtendRpcFacade
          .getUserExtendByUserId(BaseContextHandler.getUserId());
      if (null != userExtend.getData()) {
        opinionFeedbackAddDTO.setFeedbackName(userExtend.getData().getRealName());
      }
      opinionFeedbackAddDTO.setFeedbackBy(BaseContextHandler.getUserId());
      opinionFeedbackAddDTO.setMobile(BaseContextHandler.getUsername());
    }
    if (null == opinionFeedbackAddDTO.getReleaseTime()) {
      opinionFeedbackAddDTO.setReleaseTime(new Date());
    }
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = opinionFeedbackRpcFacade
        .save(OpinionFeedbackConvert.INSTANCE.convert(opinionFeedbackAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param opinionFeedbackUpdateDTO 更新参数
   * @return
   */
  public int update(OpinionFeedbackUpdateDTO opinionFeedbackUpdateDTO) {
    BaseResponse baseResponse = opinionFeedbackRpcFacade
        .update(OpinionFeedbackConvert.INSTANCE.convert(opinionFeedbackUpdateDTO));
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
    BaseResponse baseResponse = opinionFeedbackRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public OpinionFeedbackVO getOpinionFeedbackById(Long id) {
    ObjectRestResponse<OpinionFeedbackRespDTO> objectRestResponse = opinionFeedbackRpcFacade
        .getOpinionFeedbackById(
            id);
    objectRestResponse.checkError();
//    OpinionFeedbackConvert.INSTANCE.convert(objectRestResponse.getData());
    return buildOpinionFeedbackVO(objectRestResponse.getData());
  }




  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<OpinionFeedbackVO> pageOpinionFeedback(
      OpinionFeedbackPageDTO pageReqDTO) {
    TableResultResponse<OpinionFeedbackRespDTO> tableResultResponse = opinionFeedbackRpcFacade
        .page(OpinionFeedbackConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
//    OpinionFeedbackConvert.INSTANCE.convert(tableResultResponse);
    TableResultResponse<OpinionFeedbackVO> response = OpinionFeedbackConvert.INSTANCE
        .convert(tableResultResponse);
    List<OpinionFeedbackVO> opinionFeedbackVOS = buildOpinionFeedbackVOList(
        tableResultResponse.getData().getRows());
    response.getData().setRows(opinionFeedbackVOS);
    return response;
  }



  /**
   * 构建OpinionFeedbackVO对象集合
   *
   * @param respDTOS
   * @return
   */
  public List<OpinionFeedbackVO> buildOpinionFeedbackVOList(List<OpinionFeedbackRespDTO> respDTOS) {
    if (CollectionUtils.isEmpty(respDTOS)) {
      return Collections.emptyList();
    }
    Set<Long> userIds = new HashSet<>();
    Set<Long> imgIds = new HashSet<>();
    for (OpinionFeedbackRespDTO dto : respDTOS) {
      userIds.add(dto.getUpdateBy());
      imgIds.addAll(dto.getImgs());
    }
    //获取用户map
    Map<Long, String> userMap = toUserMap(userIds);
    //获取资源map
    Map<Long, String> resourceMap = toResourceMap(imgIds);

    List<OpinionFeedbackVO> vos = new ArrayList<>();
    for (OpinionFeedbackRespDTO respDTO : respDTOS) {
      OpinionFeedbackVO vo = build(respDTO);
      vo.setUpdateName(userMap.get(respDTO.getUpdateBy()));
      List<String> urls = new ArrayList<>();
      for (Long id : respDTO.getImgs()) {
        String url = resourceMap.get(id);
        if (StringUtils.isNotBlank(url)) {
          urls.add(url);
        }
      }
      vo.setImgs(urls);
      vos.add(vo);
    }
    return vos;
  }


  /**
   * 构建OpinionFeedbackVO对象
   *
   * @param respDTO
   * @return
   */
  public OpinionFeedbackVO buildOpinionFeedbackVO(OpinionFeedbackRespDTO respDTO) {
    if (null == respDTO) {
      return OpinionFeedbackVO.builder().build();
    }
    Set<Long> userIds = new HashSet<>();
    Set<Long> imgIds = new HashSet<>();
    userIds.add(respDTO.getUpdateBy());
    imgIds.addAll(respDTO.getImgs());
    //获取修改人用户扩展信息
    ObjectRestResponse<UserExtendRespDTO> userExtend = userExtendRpcFacade
        .getUserExtendByUserId(respDTO.getUpdateBy());

    //获取资源map
    Map<Long, String> resourceMap = toResourceMap(imgIds);

    OpinionFeedbackVO vo = build(respDTO);
    if (null != userExtend.getData()) {
      vo.setUpdateName(userExtend.getData().getRealName());
    }
    List<String> urls = new ArrayList<>();
    for (Long id : respDTO.getImgs()) {
      String url = resourceMap.get(id);
      if (StringUtils.isNotBlank(url)) {
        urls.add(url);
      }
    }
    vo.setImgs(urls);

    return vo;
  }

  /**
   * 构建vo
   *
   * @param respDTO
   * @return
   */
  public OpinionFeedbackVO build(OpinionFeedbackRespDTO respDTO) {
    OpinionFeedbackVO vo = OpinionFeedbackVO.builder()
        .id(respDTO.getId())
        .feedbackName(respDTO.getFeedbackName())
        .mobile(respDTO.getMobile())
        .releasePlatformType(ReleasePlatformTypeEnum.getValue(respDTO.getReleasePlatformType()))
        .releaseTime(respDTO.getReleaseTime())
        .handleStatus(HandleStatusEnum.getValue(respDTO.getHandleStatus()))
        .updateTime(respDTO.getUpdateTime())
        .feedbackContent(respDTO.getFeedbackContent())
        .content(respDTO.getContent())
        .build();
    return vo;
  }

  /**
   * 返回key:userid，value:realName的map 例: 11000L  张三
   *
   * @param ids
   * @return
   */
  public Map<Long, String> toUserMap(Set<Long> ids) {
    //todo 这个方法无效，后续要改
    ObjectRestResponse<List<UserExtendRespDTO>> userResponse = userExtendRpcFacade
        .listUserExtends(new UserExtendListQueryReqDTO());
    Map<Long, String> userMap = userResponse.getData().stream().collect(
        Collectors.toMap(UserExtendRespDTO::getUserId, u -> u.getRealName(), (k1, k2) -> k2));
    return userMap;
  }

  /**
   * 返回key:resourceId, value: fileUrl
   *
   * @param ids
   * @return
   */
  public Map<Long, String> toResourceMap(Set<Long> ids) {
    ResourceListQueryReqDTO listQuery = new ResourceListQueryReqDTO();
    listQuery.setIds(ids);
    ObjectRestResponse<List<ResourceRespDTO>> resourceResponse = resourceRpcFacade
        .listResources(listQuery);
    Map<Long, String> resourceMap = resourceResponse.getData().stream()
        .collect(Collectors.toMap(ResourceRespDTO::getId, r -> r.getFileUrl(), (k1, k2) -> k2));
    return resourceMap;
  }


}
