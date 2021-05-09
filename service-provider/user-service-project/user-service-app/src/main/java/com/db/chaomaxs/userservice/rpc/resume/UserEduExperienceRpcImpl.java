package com.db.chaomaxs.userservice.rpc.resume;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.resume.UserEduExperienceManager;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperiencePageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.UserEduExperienceRpcFacade;
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
public class UserEduExperienceRpcImpl implements UserEduExperienceRpcFacade {

  @Autowired
  private UserEduExperienceManager userEduExperienceManager;

  @Override
  public BaseResponse save(UserEduExperienceCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userEduExperienceManager.saveUserEduExperience(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserEduExperienceUpdateReqDTO updateReqDTO) {
    userEduExperienceManager.updateUserEduExperience(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    userEduExperienceManager.deleteUserEduExperience(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserEduExperienceRespDTO> getUserEduExperienceById(Long id) {
    UserEduExperienceRespDTO userEduExperience = userEduExperienceManager
        .getUserEduExperienceById(id);
    return new ObjectRestResponse<>().data(userEduExperience);
  }

  @Override
  public ObjectRestResponse<List<UserEduExperienceRespDTO>> listUserEduExperiences(
      UserEduExperienceListQueryReqDTO listQuery) {
    List<UserEduExperienceRespDTO> list = userEduExperienceManager
        .listUserEduExperiences(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserEduExperienceRespDTO> page(
      UserEduExperiencePageReqDTO pageReqDTO) {
    PageResult<UserEduExperienceRespDTO> pageResult = userEduExperienceManager
        .pageUserEduExperience(pageReqDTO);
    TableResultResponse<UserEduExperienceRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public ObjectRestResponse<UserEduExperienceRespDTO> getLastStepByUserId(Long userId) {
    UserEduExperienceRespDTO userEduExperience = userEduExperienceManager
        .getLastStepByUserId(userId);
    return new ObjectRestResponse<>().data(userEduExperience);
  }

}
