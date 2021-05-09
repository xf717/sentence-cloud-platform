package com.db.chaomaxs.systemservice.rpc.auth.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.auth.BaseGroupRpcImpl;
import com.db.chaomaxs.systemservice.rpc.auth.dto.AuthorityMenuTreeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.GroupUsersRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.facade.api.BaseGroupApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@RestController
public class BaseGroupRpcController implements BaseGroupApi {

  @Autowired
  private BaseGroupRpcImpl baseGroupRpc;

  @Override
  public BaseResponse save(@RequestBody BaseGroupCreateReqDTO baseGroupCreateReqDTO) {
    return baseGroupRpc.save(baseGroupCreateReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody BaseGroupUpdateReqDTO baseGroupUpdateReqDTO) {
    return baseGroupRpc.update(baseGroupUpdateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return baseGroupRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<BaseGroupRespDTO> getBaseGroupById(@PathVariable("id") Long id) {

    return baseGroupRpc.getBaseGroupById(id);
  }

  @Override
  public ObjectRestResponse<List<BaseGroupRespDTO>> listBaseGroups(
      @RequestBody BaseGroupListQueryReqDTO listQuery) {
    return baseGroupRpc.listBaseGroups(listQuery);
  }

  @Override
  public TableResultResponse<BaseGroupRespDTO> page(@RequestBody BaseGroupPageReqDTO page) {
    return baseGroupRpc.page(page);
  }

  @Override
  public BaseResponse updateGroupUsers(Long groupId, String members, String leaders) {
    return baseGroupRpc.updateGroupUsers(groupId, members, leaders);
  }

  @Override
  public ObjectRestResponse<GroupUsersRespDTO> getGroupUsers(Long groupId) {
    return baseGroupRpc.getGroupUsers(groupId);
  }

  @Override
  public BaseResponse updateAuthorityMenu(Long groupId, String menuTrees) {
    return baseGroupRpc.updateAuthorityMenu(groupId, menuTrees);
  }

  @Override
  public ObjectRestResponse<List<AuthorityMenuTreeRespDTO>> listAuthorityMenus(Long groupId) {
    return baseGroupRpc.listAuthorityMenus(groupId);
  }

  @Override
  public BaseResponse updateAuthorityElement(Long groupId, Long elementId) {
    return baseGroupRpc.updateAuthorityElement(groupId, elementId);
  }

  @Override
  public BaseResponse removeAuthorityElement(Long groupId, Long elementId) {
    return baseGroupRpc.removeAuthorityElement(groupId, elementId);
  }

  @Override
  public ObjectRestResponse<List<Long>> listAuthorityElementIds(Long groupId) {
    return baseGroupRpc.listAuthorityElementIds(groupId);
  }
}
