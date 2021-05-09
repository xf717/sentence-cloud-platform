package com.github.xf717.userservice.rpc.resume;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.resume.UserWorkExperienceManager;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperiencePageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserWorkExperienceRpcFacade;
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
public class UserWorkExperienceRpcImpl implements UserWorkExperienceRpcFacade {

  @Autowired
  private UserWorkExperienceManager userWorkExperienceManager;

  @Override
  public BaseResponse save(UserWorkExperienceCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userWorkExperienceManager.saveUserWorkExperience(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserWorkExperienceUpdateReqDTO updateReqDTO) {
    userWorkExperienceManager.updateUserWorkExperience(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      userWorkExperienceManager.deleteUserWorkExperience(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserWorkExperienceRespDTO> getUserWorkExperienceById(Long id) {
      UserWorkExperienceRespDTO userWorkExperience = userWorkExperienceManager.getUserWorkExperienceById(id);
    return new ObjectRestResponse<>().data(userWorkExperience);
  }

  @Override
  public ObjectRestResponse<List<UserWorkExperienceRespDTO>> listUserWorkExperiences(UserWorkExperienceListQueryReqDTO listQuery) {
    List<UserWorkExperienceRespDTO> list = userWorkExperienceManager.listUserWorkExperiences(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserWorkExperienceRespDTO> page(UserWorkExperiencePageReqDTO pageReqDTO) {
    PageResult<UserWorkExperienceRespDTO> pageResult = userWorkExperienceManager.pageUserWorkExperience(pageReqDTO);
    TableResultResponse<UserWorkExperienceRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public ObjectRestResponse<UserWorkExperienceRespDTO> getLastStepByUserId(Long userId) {
    UserWorkExperienceRespDTO userWorkExperience = userWorkExperienceManager.getLastStepByUserId(userId);
    return new ObjectRestResponse<>().data(userWorkExperience);
  }

}
