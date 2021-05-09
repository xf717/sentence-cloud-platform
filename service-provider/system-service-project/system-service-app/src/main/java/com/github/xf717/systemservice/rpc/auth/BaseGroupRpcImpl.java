package com.github.xf717.systemservice.rpc.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.auth.BaseGroupManager;
import com.github.xf717.systemservice.rpc.auth.dto.AuthorityMenuTreeRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.GroupUsersRespDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseGroupRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaseGroupRpcImpl implements BaseGroupRpcFacade {

  @Autowired
  private BaseGroupManager baseGroupManager;

  @Override
  public BaseResponse save(BaseGroupCreateReqDTO baseGroupCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    baseGroupManager.saveBaseGroup(baseGroupCreateReqDTO);
    return BaseResponse.success("保存成功");
  }


  @Override
  public BaseResponse update(BaseGroupUpdateReqDTO baseGroupUpdateReqDTO) {
    baseGroupManager.updateBaseGroup(baseGroupUpdateReqDTO);
    return BaseResponse.success("修改成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    baseGroupManager.deleteBaseGroup(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<BaseGroupRespDTO> getBaseGroupById(Long id) {
    BaseGroupRespDTO groupRespDTO = baseGroupManager.getBaseGroupById(id);
    return new ObjectRestResponse<>().data(groupRespDTO);
  }

  @Override
  public ObjectRestResponse<List<BaseGroupRespDTO>> listBaseGroups(
      BaseGroupListQueryReqDTO listQuery) {
    List<BaseGroupRespDTO> list = baseGroupManager.listBaseGroups(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<BaseGroupRespDTO> page(BaseGroupPageReqDTO pageReqDTO) {
    PageResult<BaseGroupRespDTO> pageResult = baseGroupManager.pageBaseGroup(pageReqDTO);
    TableResultResponse<BaseGroupRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public BaseResponse updateGroupUsers(Long groupId, String members, String leaders) {
    baseGroupManager.updateGroupUsers(groupId, members, leaders);
    return BaseResponse.success("成功");
  }

  @Override
  public ObjectRestResponse<GroupUsersRespDTO> getGroupUsers(Long groupId) {
    GroupUsersRespDTO groupUsers = baseGroupManager.getGroupUsers(groupId);
    return new ObjectRestResponse<>().data(groupUsers);
  }

  @Override
  public BaseResponse updateAuthorityMenu(Long groupId, String menuTrees) {
    baseGroupManager.updateAuthorityMenu(groupId, menuTrees);
    return BaseResponse.success("成功");
  }

  @Override
  public ObjectRestResponse<List<AuthorityMenuTreeRespDTO>> listAuthorityMenus(Long groupId) {
    List<AuthorityMenuTreeRespDTO> list = baseGroupManager.listAuthorityMenus(groupId);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public BaseResponse updateAuthorityElement(Long groupId, Long elementId) {
    baseGroupManager.updateAuthorityElement(groupId, elementId);
    return BaseResponse.success("成功");
  }

  @Override
  public BaseResponse removeAuthorityElement(Long groupId, Long elementId) {
    baseGroupManager.removeAuthorityElement(groupId, elementId);
    return BaseResponse.success("成功");
  }

  @Override
  public ObjectRestResponse<List<Long>> listAuthorityElementIds(Long groupId) {
    List<Long> idList = baseGroupManager.listAuthorityElementIds(groupId);
    return new ObjectRestResponse<>().data(idList);
  }

}
