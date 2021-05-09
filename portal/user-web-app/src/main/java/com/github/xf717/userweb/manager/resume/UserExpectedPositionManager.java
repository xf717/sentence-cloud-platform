package com.github.xf717.userweb.manager.resume;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedAndStatusRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionRespDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserExpectedPositionRpcFacade;
import com.github.xf717.userservice.rpc.resume.facade.UserResumeRpcFacade;
import com.github.xf717.userweb.controller.resume.dto.UserExpectedPositionAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserExpectedPositionUpdateDTO;
import com.github.xf717.userweb.controller.resume.dto.UserPositionWantedStatusDTO;
import com.github.xf717.userweb.controller.resume.vo.UserExpectedAndStatusVO;
import com.github.xf717.userweb.controller.resume.vo.UserExpectedPositionVO;
import com.github.xf717.userweb.convert.resume.UserExpectedPositionConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserExpectedPositionManager
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserExpectedPositionManager {

  @Autowired
  private UserExpectedPositionRpcFacade userExpectedPositionRpcFacade;

  @Autowired
  private UserResumeRpcFacade userResumeRpcFacade;

  /**
   * 添加数据
   * @param userExpectedPositionAddDTO 添加参数
   * @return
   */
  public int save(UserExpectedPositionAddDTO userExpectedPositionAddDTO) {
    UserExpectedPositionCreateReqDTO reqDTO = UserExpectedPositionConvert.INSTANCE
        .convert(userExpectedPositionAddDTO);
    reqDTO.setUserId(Long.parseLong(BaseContextHandler.getUserID()));
    BaseResponse baseResponse = userExpectedPositionRpcFacade.save(reqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param userExpectedPositionUpdateDTO  更新参数
   * @return
   */
  public int update(UserExpectedPositionUpdateDTO userExpectedPositionUpdateDTO) {
    BaseResponse baseResponse = userExpectedPositionRpcFacade
        .update(UserExpectedPositionConvert.INSTANCE.convert(userExpectedPositionUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = userExpectedPositionRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public UserExpectedPositionVO getUserExpectedPositionById(Long id) {
    ObjectRestResponse<UserExpectedPositionRespDTO> objectRestResponse = userExpectedPositionRpcFacade.getUserExpectedPositionById(
        id);
    objectRestResponse.checkError();
    return UserExpectedPositionConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据用户id 查询求职期望和在职状态
   * @param userId
   * @return
   */
  public UserExpectedAndStatusVO getUserExpectedAndStatusByUserId(Long userId) {
    ObjectRestResponse<UserExpectedAndStatusRespDTO> objectRestResponse = userExpectedPositionRpcFacade
        .getUserExpectedAndStatusByUserId(userId);
    objectRestResponse.checkError();
    UserExpectedAndStatusVO userExpectedAndStatusVO = new UserExpectedAndStatusVO();
    userExpectedAndStatusVO.setUserExpectedPositionVOList(UserExpectedPositionConvert.INSTANCE
        .convertList(objectRestResponse.getData().getUserExpectedPositionVOList()));
    userExpectedAndStatusVO.setPositionWantedDictionaryId(
        objectRestResponse.getData().getPositionWantedDictionaryId());
    userExpectedAndStatusVO.setUserResumeId(objectRestResponse.getData().getUserResumeId());
    userExpectedAndStatusVO
        .setPositionWantedStatusName(objectRestResponse.getData().getPositionWantedStatusName());
    return userExpectedAndStatusVO;
  }

  public int updatePositionWantedStatus(UserPositionWantedStatusDTO updateDTO){
    BaseResponse baseResponse = userResumeRpcFacade
        .update(UserExpectedPositionConvert.INSTANCE.convert(updateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

}
