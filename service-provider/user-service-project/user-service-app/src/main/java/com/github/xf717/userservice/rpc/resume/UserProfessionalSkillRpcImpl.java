package com.github.xf717.userservice.rpc.resume;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.resume.UserProfessionalSkillManager;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillPageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserProfessionalSkillRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Slf4j
@Service
public class UserProfessionalSkillRpcImpl implements UserProfessionalSkillRpcFacade {

  @Autowired
  private UserProfessionalSkillManager userProfessionalSkillManager;

  @Override
  public BaseResponse save(UserProfessionalSkillCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userProfessionalSkillManager.saveUserProfessionalSkill(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserProfessionalSkillUpdateReqDTO updateReqDTO) {
    userProfessionalSkillManager.updateUserProfessionalSkill(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    userProfessionalSkillManager.deleteUserProfessionalSkill(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserProfessionalSkillRespDTO> getUserProfessionalSkillById(Long id) {
    UserProfessionalSkillRespDTO userProfessionalSkill = userProfessionalSkillManager
        .getUserProfessionalSkillById(id);
    return new ObjectRestResponse<>().data(userProfessionalSkill);
  }

  @Override
  public ObjectRestResponse<List<UserProfessionalSkillRespDTO>> listUserProfessionalSkills(
      UserProfessionalSkillListQueryReqDTO listQuery) {
    List<UserProfessionalSkillRespDTO> list = userProfessionalSkillManager
        .listUserProfessionalSkills(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserProfessionalSkillRespDTO> page(
      UserProfessionalSkillPageReqDTO pageReqDTO) {
    PageResult<UserProfessionalSkillRespDTO> pageResult = userProfessionalSkillManager
        .pageUserProfessionalSkill(pageReqDTO);
    TableResultResponse<UserProfessionalSkillRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
