package com.github.xf717.userservice.rpc.resume;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.resume.UserWorkSkillTagManager;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkSkillTagCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkSkillTagListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkSkillTagPageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkSkillTagRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkSkillTagUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserWorkSkillTagRpcFacade;
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
public class UserWorkSkillTagRpcImpl implements UserWorkSkillTagRpcFacade {

  @Autowired
  private UserWorkSkillTagManager userWorkSkillTagManager;

  @Override
  public BaseResponse save(UserWorkSkillTagCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userWorkSkillTagManager.saveUserWorkSkillTag(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserWorkSkillTagUpdateReqDTO updateReqDTO) {
    userWorkSkillTagManager.updateUserWorkSkillTag(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      userWorkSkillTagManager.deleteUserWorkSkillTag(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserWorkSkillTagRespDTO> getUserWorkSkillTagById(Long id) {
      UserWorkSkillTagRespDTO userWorkSkillTag = userWorkSkillTagManager.getUserWorkSkillTagById(id);
    return new ObjectRestResponse<>().data(userWorkSkillTag);
  }

  @Override
  public ObjectRestResponse<List<UserWorkSkillTagRespDTO>> listUserWorkSkillTags(UserWorkSkillTagListQueryReqDTO listQuery) {
    List<UserWorkSkillTagRespDTO> list = userWorkSkillTagManager.listUserWorkSkillTags(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserWorkSkillTagRespDTO> page(UserWorkSkillTagPageReqDTO pageReqDTO) {
    PageResult<UserWorkSkillTagRespDTO> pageResult = userWorkSkillTagManager.pageUserWorkSkillTag(pageReqDTO);
    TableResultResponse<UserWorkSkillTagRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
