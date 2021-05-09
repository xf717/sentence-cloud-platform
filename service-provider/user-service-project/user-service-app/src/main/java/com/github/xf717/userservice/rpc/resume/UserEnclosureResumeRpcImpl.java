package com.github.xf717.userservice.rpc.resume;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.resume.UserEnclosureResumeManager;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumePageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserEnclosureResumeRpcFacade;
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
public class UserEnclosureResumeRpcImpl implements UserEnclosureResumeRpcFacade {

  @Autowired
  private UserEnclosureResumeManager userEnclosureResumeManager;

  @Override
  public BaseResponse save(UserEnclosureResumeCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userEnclosureResumeManager.saveUserEnclosureResume(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserEnclosureResumeUpdateReqDTO updateReqDTO) {
    userEnclosureResumeManager.updateUserEnclosureResume(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    userEnclosureResumeManager.deleteUserEnclosureResume(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserEnclosureResumeRespDTO> getUserEnclosureResumeById(Long id) {
    UserEnclosureResumeRespDTO userEnclosureResume = userEnclosureResumeManager
        .getUserEnclosureResumeById(id);
    return new ObjectRestResponse<>().data(userEnclosureResume);
  }

  @Override
  public ObjectRestResponse<List<UserEnclosureResumeRespDTO>> listUserEnclosureResumes(Long userId) {
    List<UserEnclosureResumeRespDTO> list = userEnclosureResumeManager
        .listUserEnclosureResumes(userId);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserEnclosureResumeRespDTO> page(
      UserEnclosureResumePageReqDTO pageReqDTO) {
    PageResult<UserEnclosureResumeRespDTO> pageResult = userEnclosureResumeManager
        .pageUserEnclosureResume(pageReqDTO);
    TableResultResponse<UserEnclosureResumeRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
