package com.github.xf717.userweb.manager.resume;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userweb.controller.resume.dto.UserProfessionalSkillAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserProfessionalSkillUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UserProfessionalSkillVO;
import com.github.xf717.userweb.convert.resume.UserProfessionalSkillConvert;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillRespDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserProfessionalSkillRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserProfessionalSkillManager
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Service
@Validated
public class UserProfessionalSkillManager {

  @Autowired
  private UserProfessionalSkillRpcFacade userProfessionalSkillRpcFacade;

  /**
   * 添加数据
   *
   * @param userProfessionalSkillAddDTO 添加参数
   * @return
   */
  public int save(UserProfessionalSkillAddDTO userProfessionalSkillAddDTO) {
    BaseResponse baseResponse = userProfessionalSkillRpcFacade
        .save(UserProfessionalSkillConvert.INSTANCE.convert(userProfessionalSkillAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param userProfessionalSkillUpdateDTO 更新参数
   * @return
   */
  public int update(UserProfessionalSkillUpdateDTO userProfessionalSkillUpdateDTO) {
    BaseResponse baseResponse = userProfessionalSkillRpcFacade
        .update(UserProfessionalSkillConvert.INSTANCE.convert(userProfessionalSkillUpdateDTO));
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
    BaseResponse baseResponse = userProfessionalSkillRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public UserProfessionalSkillVO getUserProfessionalSkillById(Long id) {
    ObjectRestResponse<UserProfessionalSkillRespDTO> objectRestResponse = userProfessionalSkillRpcFacade
        .getUserProfessionalSkillById(
            id);
    objectRestResponse.checkError();
    return UserProfessionalSkillConvert.INSTANCE.convert(objectRestResponse.getData());
  }

}
