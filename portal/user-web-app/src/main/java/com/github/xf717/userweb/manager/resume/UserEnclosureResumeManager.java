package com.github.xf717.userweb.manager.resume;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeCreateReqDTO;
import com.github.xf717.userweb.controller.resume.dto.UserEnclosureResumeAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserEnclosureResumeUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UserEnclosureResumeVO;
import com.github.xf717.userweb.convert.resume.UserEnclosureResumeConvert;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeRespDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserEnclosureResumeRpcFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserEnclosureResumeManager
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserEnclosureResumeManager {

  @Autowired
  private UserEnclosureResumeRpcFacade userEnclosureResumeRpcFacade;

  /**
   * 添加数据
   *
   * @param userEnclosureResumeAddDTO 添加参数
   * @return
   */
  public int save(UserEnclosureResumeAddDTO userEnclosureResumeAddDTO) {
    UserEnclosureResumeCreateReqDTO userEnclosureResumeCreateReqDTO= UserEnclosureResumeConvert.
        INSTANCE.convert(userEnclosureResumeAddDTO);
    userEnclosureResumeCreateReqDTO.setUserId(Long.parseLong(BaseContextHandler.getUserID()));
    BaseResponse baseResponse = userEnclosureResumeRpcFacade
        .save(userEnclosureResumeCreateReqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param userEnclosureResumeUpdateDTO 更新参数
   * @return
   */
  public int update(UserEnclosureResumeUpdateDTO userEnclosureResumeUpdateDTO) {
    BaseResponse baseResponse = userEnclosureResumeRpcFacade
        .update(UserEnclosureResumeConvert.INSTANCE.convert(userEnclosureResumeUpdateDTO));
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
    BaseResponse baseResponse = userEnclosureResumeRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public UserEnclosureResumeVO getUserEnclosureResumeById(Long id) {
    ObjectRestResponse<UserEnclosureResumeRespDTO> objectRestResponse = userEnclosureResumeRpcFacade
        .getUserEnclosureResumeById(
            id);
    objectRestResponse.checkError();
    return UserEnclosureResumeConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据用户id查询管理附件简历数据
   *
   * @return
   */
  public List<UserEnclosureResumeVO> listUserEnclosureResumes() {
    Long userId = Long.parseLong(BaseContextHandler.getUserID());
    ObjectRestResponse<List<UserEnclosureResumeRespDTO>> objectRestResponse = userEnclosureResumeRpcFacade
        .listUserEnclosureResumes(userId);
    objectRestResponse.checkError();
    return UserEnclosureResumeConvert.INSTANCE.convertList(objectRestResponse.getData());
  }


}
