package com.db.chaomaxs.systemservice.service.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.ServiceException;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.constant.AdminCommonConstant;
import com.db.chaomaxs.systemservice.convert.auth.BaseGroupConvert;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseGroupDO;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseGroupLeaderDO;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseGroupMemberDO;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseMenuDO;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseResourceAuthorityDO;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.auth.BaseGroupLeaderMapper;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.auth.BaseGroupMapper;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.auth.BaseGroupMemberMapper;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.auth.BaseMenuMapper;
import com.db.chaomaxs.systemservice.dal.mysql.mapper.auth.BaseResourceAuthorityMapper;
import com.db.chaomaxs.systemservice.enums.SystemErrorCodeConstants;
import com.db.chaomaxs.systemservice.rpc.auth.dto.AuthorityMenuTreeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseResourceAuthorityListQueryReqDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * ResourceService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class BaseGroupService {

  @Autowired
  private BaseGroupMapper baseGroupMapper;

  @Autowired
  private BaseGroupMemberMapper baseGroupMemberMapper;

  @Autowired
  private BaseGroupLeaderMapper baseGroupLeaderMapper;

  @Autowired
  private BaseResourceAuthorityMapper baseResourceAuthorityMapper;

  @Autowired
  private BaseMenuMapper baseMenuMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseGroup(BaseGroupCreateReqDTO createReqDTO) {
    return baseGroupMapper.insert(BaseGroupConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseGroup(BaseGroupUpdateReqDTO updateReqDTO) {
    BaseGroupDO baseGroupDO = baseGroupMapper.selectById(updateReqDTO.getId());
    if (baseGroupDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    baseGroupDO = BaseGroupConvert.INSTANCE.convert(updateReqDTO);
    int result = baseGroupMapper.updateById(baseGroupDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseGroup(Long id) {
    if (baseGroupMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    int result = baseGroupMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseGroupRespDTO> listBaseGroups(BaseGroupListQueryReqDTO listQueryReqDTO) {
    List<BaseGroupDO> list = baseGroupMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return BaseGroupConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseGroupRespDTO getBaseGroupById(Long id) {
    BaseGroupDO BaseGroupDO = baseGroupMapper.selectById(id);
    if (BaseGroupDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.ADMIN_USERNAME_NOT_EXISTS.getCode());
    }
    return BaseGroupConvert.INSTANCE.convert(BaseGroupDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseGroupRespDTO> pageBaseGroup(BaseGroupPageReqDTO page) {
    IPage<BaseGroupDO> baseGroupPage = baseGroupMapper.selectPage(page);
    return BaseGroupConvert.INSTANCE.convertPage(baseGroupPage);
  }

  /**
   * 修改组用户,参数就暂用字符串
   *
   * @param groupId
   * @param members
   * @param leaders
   */
  @Transactional(rollbackFor = ServiceException.class)
  public void updateGroupUsers(Long groupId, String members, String leaders) {
    this.baseGroupLeaderMapper.removeGroupLeadersById(groupId);
    this.baseGroupMemberMapper.removeGroupMembersById(groupId);
    if (StringUtils.isNotEmpty(members)) {
      String[] mem = members.split(",");
      BaseGroupMemberDO baseGroupMemberDO = null;
      List<BaseGroupMemberDO> memberDOList = new ArrayList<>(mem.length);
      // 数据最不多，简单
      for (String m : mem) {
        baseGroupMemberDO = new BaseGroupMemberDO().setGroupId(groupId)
            .setUserId(Long.parseLong(m)).setDescription("插入数据groupId:" + groupId + " userId:" + m);
        memberDOList.add(baseGroupMemberDO);
      }
      // 批量插入数据
      baseGroupMemberMapper.insertByBatch(memberDOList);
    }

    if (StringUtils.isNotEmpty(leaders)) {
      String[] mem = leaders.split(",");
      BaseGroupLeaderDO baseGroupLeaderDO = null;
      List<BaseGroupLeaderDO> leaderDOList = new ArrayList<>(mem.length);
      for (String m : mem) {
        baseGroupLeaderDO = new BaseGroupLeaderDO().setGroupId(groupId).setUserId(Long.parseLong(m))
            .setDescription("插入数据groupId:" + groupId + " userId:" + m);
        leaderDOList.add(baseGroupLeaderDO);
      }
      baseGroupLeaderMapper.insertByBatch(leaderDOList);
    }

  }

  /**
   * 变更群组关联的菜单
   *
   * @param groupId
   * @param menus
   */
  public void updateAuthorityMenu(Long groupId, String menuTrees) {
    String[] menus = menuTrees.split(",");
    baseResourceAuthorityMapper
        .removeByAuthorityIdAndResourceType(groupId + "", AdminCommonConstant.RESOURCE_TYPE_MENU);
    List<BaseMenuDO> menuList = baseMenuMapper.selectAllList();
    Map<String, String> map = new HashMap<String, String>();
    for (BaseMenuDO menu : menuList) {
      map.put(menu.getId().toString(), menu.getParentId().toString());
    }
    Set<String> relationMenus = new HashSet<String>();
    relationMenus.addAll(Arrays.asList(menus));
    BaseResourceAuthorityDO authority = null;
    for (String menuId : menus) {
      findParentID(map, relationMenus, menuId);
    }
    List<BaseResourceAuthorityDO> list = new ArrayList<>(relationMenus.size());
    for (String menuId : relationMenus) {
      authority = new BaseResourceAuthorityDO()
          .setAuthorityType(AdminCommonConstant.AUTHORITY_TYPE_GROUP)
          .setResourceType(AdminCommonConstant.RESOURCE_TYPE_MENU);
      authority.setAuthorityId(groupId);
      authority.setResourceId(Long.valueOf(menuId));
      authority.setParentId(-1L);
      list.add(authority);
    }
    // 批量插入数据
    baseResourceAuthorityMapper.insertByBatch(list);
  }

  private void findParentID(Map<String, String> map, Set<String> relationMenus, String id) {
    String parentId = map.get(id);
    if (String.valueOf(AdminCommonConstant.ROOT).equals(id)) {
      return;
    }
    relationMenus.add(parentId);
    findParentID(map, relationMenus, parentId);
  }

  /**
   * 获取权限菜单
   *
   * @param groupId
   * @return
   */
  public List<AuthorityMenuTreeRespDTO> listAuthorityMenus(Long groupId) {
    List<BaseMenuDO> menus = baseMenuMapper
        .selectMenuByAuthorityId(String.valueOf(groupId), AdminCommonConstant.AUTHORITY_TYPE_GROUP);
    if (CollectionUtils.isEmpty(menus)) {
      return Collections.emptyList();
    }
    List<AuthorityMenuTreeRespDTO> trees = new ArrayList<>();
    AuthorityMenuTreeRespDTO node = null;
    for (BaseMenuDO menu : menus) {
      node = new AuthorityMenuTreeRespDTO();
      node.setText(menu.getTitle());
      BeanUtils.copyProperties(menu, node);
      trees.add(node);
    }
    return trees;
  }

  /**
   * 分配资源权限
   *
   * @param groupId
   * @param elementId
   */
  public void updateAuthorityElement(Long groupId, Long elementId) {
    BaseResourceAuthorityDO authority = new BaseResourceAuthorityDO()
        .setAuthorityType(AdminCommonConstant.AUTHORITY_TYPE_GROUP)
        .setResourceType(AdminCommonConstant.RESOURCE_TYPE_BTN);
    authority.setAuthorityId(groupId);
    authority.setResourceId(elementId);
    authority.setParentId(-1L);
    baseResourceAuthorityMapper.insert(authority);
  }

  /**
   * 移除资源权限
   *
   * @param groupId
   * @param elementId
   */
  public void removeAuthorityElement(Long groupId, Long elementId) {
    baseResourceAuthorityMapper.removeAuthorityElement(groupId, elementId, -1L);
  }

  /**
   * 获取群组关联的资源
   *
   * @param groupId
   * @return
   */
  public List<Long> listAuthorityElementIds(Long groupId) {
    BaseResourceAuthorityListQueryReqDTO listQueryReqDTO = new BaseResourceAuthorityListQueryReqDTO()
        .setAuthorityType(AdminCommonConstant.AUTHORITY_TYPE_GROUP)
        .setResourceType(AdminCommonConstant.RESOURCE_TYPE_BTN)
        .setAuthorityId(groupId);
    List<BaseResourceAuthorityDO> resourceAuthorityDOList = baseResourceAuthorityMapper
        .selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(resourceAuthorityDOList)) {
      return Collections.emptyList();
    }
    List<Long> ids = new ArrayList<>(resourceAuthorityDOList.size());
    for (BaseResourceAuthorityDO baseResourceAuthorityDO : resourceAuthorityDOList) {
      ids.add(baseResourceAuthorityDO.getResourceId());
    }
    return ids;
  }

}
