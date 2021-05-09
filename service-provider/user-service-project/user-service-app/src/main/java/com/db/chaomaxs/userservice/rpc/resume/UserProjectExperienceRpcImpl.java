package com.db.chaomaxs.userservice.rpc.resume;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.resume.UserProjectExperienceManager;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperiencePageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.UserProjectExperienceRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Slf4j
@Service
public class UserProjectExperienceRpcImpl implements UserProjectExperienceRpcFacade {

  @Autowired
  private UserProjectExperienceManager userProjectExperienceManager;

  @Override
  public BaseResponse save(UserProjectExperienceCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userProjectExperienceManager.saveUserProjectExperience(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserProjectExperienceUpdateReqDTO updateReqDTO) {
    userProjectExperienceManager.updateUserProjectExperience(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    userProjectExperienceManager.deleteUserProjectExperience(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserProjectExperienceRespDTO> getUserProjectExperienceById(Long id) {
    UserProjectExperienceRespDTO userProjectExperience = userProjectExperienceManager
        .getUserProjectExperienceById(id);
    return new ObjectRestResponse<>().data(userProjectExperience);
  }

  @Override
  public ObjectRestResponse<List<UserProjectExperienceRespDTO>> listUserProjectExperiences(
      UserProjectExperienceListQueryReqDTO listQuery) {
    List<UserProjectExperienceRespDTO> list = userProjectExperienceManager
        .listUserProjectExperiences(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserProjectExperienceRespDTO> page(
      UserProjectExperiencePageReqDTO pageReqDTO) {
    PageResult<UserProjectExperienceRespDTO> pageResult = userProjectExperienceManager
        .pageUserProjectExperience(pageReqDTO);
    TableResultResponse<UserProjectExperienceRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
