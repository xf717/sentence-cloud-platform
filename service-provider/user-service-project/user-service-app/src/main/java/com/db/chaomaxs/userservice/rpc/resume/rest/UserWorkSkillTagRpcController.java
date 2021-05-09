package com.db.chaomaxs.userservice.rpc.resume.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.resume.UserWorkSkillTagRpcImpl;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagPageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.api.UserWorkSkillTagApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_工作经历_技能标签信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@RestController
public class UserWorkSkillTagRpcController implements UserWorkSkillTagApi {

  @Autowired
  private UserWorkSkillTagRpcImpl userWorkSkillTagRpc;

  @Override
  public BaseResponse save(@RequestBody UserWorkSkillTagCreateReqDTO createReqDTO) {
    return userWorkSkillTagRpc.save(createReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody UserWorkSkillTagUpdateReqDTO updateReqDTO) {
    return userWorkSkillTagRpc.update(updateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return userWorkSkillTagRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<UserWorkSkillTagRespDTO> getUserWorkSkillTagById(
      @PathVariable("id") Long id) {
    return userWorkSkillTagRpc.getUserWorkSkillTagById(id);
  }

  @Override
  public ObjectRestResponse<List<UserWorkSkillTagRespDTO>> listUserWorkSkillTags(
      @RequestBody UserWorkSkillTagListQueryReqDTO listQuery) {
    return userWorkSkillTagRpc.listUserWorkSkillTags(listQuery);
  }

  @Override
  public TableResultResponse<UserWorkSkillTagRespDTO> page(
      @RequestBody UserWorkSkillTagPageReqDTO pageReqDTO) {
    return userWorkSkillTagRpc.page(pageReqDTO);
  }
}
