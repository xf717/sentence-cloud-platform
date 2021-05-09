package com.db.chaomaxs.systemservice.manager.auth;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.rpc.auth.dto.AuthorityMenuTreeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.GroupUsersRespDTO;
import com.db.chaomaxs.systemservice.service.auth.BaseGroupService;
import com.db.chaomaxs.systemservice.service.auth.BaseUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseGroupManager
 *
 * @author ding, xiaofeng
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseGroupManager {

  @Autowired
  private BaseGroupService baseGroupService;

  @Autowired
  private BaseUserService baseUserService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseGroup(BaseGroupCreateReqDTO createReqDTO) {
    return baseGroupService.saveBaseGroup(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseGroup(BaseGroupUpdateReqDTO updateReqDTO) {
    return baseGroupService.updateBaseGroup(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseGroup(Long id) {
    return baseGroupService.deleteBaseGroup(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseGroupRespDTO> listBaseGroups(BaseGroupListQueryReqDTO listQueryReqDTO) {
    return baseGroupService.listBaseGroups(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseGroupRespDTO getBaseGroupById(Long id) {
    return baseGroupService.getBaseGroupById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseGroupRespDTO> pageBaseGroup(BaseGroupPageReqDTO page) {
    return baseGroupService.pageBaseGroup(page);
  }

  /**
   * 修改用户组信息
   *
   * @param groupId
   * @param members
   * @param leaders
   */
  public void updateGroupUsers(Long groupId, String members, String leaders) {
    baseGroupService.updateGroupUsers(groupId, members, leaders);
  }

  /**
   * 变更群组关联的菜单
   *
   * @param groupId
   * @param menuTrees
   */
  public void updateAuthorityMenu(Long groupId, String menuTrees) {
    baseGroupService.updateAuthorityMenu(groupId, menuTrees);
  }

  /**
   * 获取群主关联的菜单
   *
   * @param groupId
   * @return
   */
  public List<AuthorityMenuTreeRespDTO> listAuthorityMenus(Long groupId) {
    return baseGroupService.listAuthorityMenus(groupId);
  }

  /**
   * 分配资源权限
   *
   * @param groupId
   * @param elementId
   */
  public void updateAuthorityElement(Long groupId, Long elementId) {
    baseGroupService.updateAuthorityElement(groupId, elementId);
  }

  /**
   * 移除资源权限
   *
   * @param groupId
   * @param elementId
   */
  public void removeAuthorityElement(Long groupId, Long elementId) {
    baseGroupService.removeAuthorityElement(groupId, elementId);
  }

  /**
   * 获取群组关联的资源
   *
   * @param groupId
   * @return
   */
  public List<Long> listAuthorityElementIds(Long groupId) {
    return baseGroupService.listAuthorityElementIds(groupId);
  }

  /**
   * 获取群组关联用户
   *
   * @param groupId
   * @return
   */
  public GroupUsersRespDTO getGroupUsers(Long groupId) {
    return baseUserService.getGroupUsers(groupId);
  }


}
