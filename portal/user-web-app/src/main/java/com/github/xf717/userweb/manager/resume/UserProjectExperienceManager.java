package com.github.xf717.userweb.manager.resume;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userweb.controller.resume.dto.UserProjectExperienceAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserProjectExperienceUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UserProjectExperienceVO;
import com.github.xf717.userweb.convert.resume.UserProjectExperienceConvert;
import com.github.xf717.userservice.rpc.resume.dto.UserProjectExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserProjectExperienceRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserProjectExperienceManager
 *
 * @author wst
 * @date 2021-03-29 13:08:13
 */
@Service
@Validated
public class UserProjectExperienceManager {

  @Autowired
  private UserProjectExperienceRpcFacade userProjectExperienceRpcFacade;

  /**
   * 添加数据
   *
   * @param userProjectExperienceAddDTO 添加参数
   * @return
   */
  public int save(UserProjectExperienceAddDTO userProjectExperienceAddDTO) {
    BaseResponse baseResponse = userProjectExperienceRpcFacade
        .save(UserProjectExperienceConvert.INSTANCE.convert(userProjectExperienceAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param userProjectExperienceUpdateDTO 更新参数
   * @return
   */
  public int update(UserProjectExperienceUpdateDTO userProjectExperienceUpdateDTO) {
    BaseResponse baseResponse = userProjectExperienceRpcFacade
        .update(UserProjectExperienceConvert.INSTANCE.convert(userProjectExperienceUpdateDTO));
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
    BaseResponse baseResponse = userProjectExperienceRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public UserProjectExperienceVO getUserProjectExperienceById(Long id) {
    ObjectRestResponse<UserProjectExperienceRespDTO> objectRestResponse = userProjectExperienceRpcFacade
        .getUserProjectExperienceById(
            id);
    objectRestResponse.checkError();
    return UserProjectExperienceConvert.INSTANCE.convert(objectRestResponse.getData());
  }

}
