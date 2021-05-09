package com.db.chaomaxs.systemservice.rpc.auth.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.auth.dto.AuthorityMenuTreeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.GroupTreeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.GroupUsersRespDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
public interface BaseGroupApi {

  /**
   * 添加数据
   *
   * @param baseGroupCreateReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/baseGroup/save")
  BaseResponse save(@RequestBody BaseGroupCreateReqDTO baseGroupCreateReqDTO);

  /**
   * 更新数据
   *
   * @param baseGroupUpdateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/baseGroup/update")
  BaseResponse update(@RequestBody BaseGroupUpdateReqDTO baseGroupUpdateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/baseGroup/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);


  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/baseGroup/get/{id}")
  ObjectRestResponse<BaseGroupRespDTO> getBaseGroupById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/baseGroup/list")
  ObjectRestResponse<List<BaseGroupRespDTO>> listBaseGroups(
      @RequestBody BaseGroupListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/baseGroup/page")
  TableResultResponse<BaseGroupRespDTO> page(@RequestBody BaseGroupPageReqDTO pageReqDTO);

  /**
   * 根据组id修改用户、用户管理员
   *
   * @param groupId
   * @param members
   * @param leaders
   * @return
   */
  @PutMapping("/facade/baseGroup/{groupId}/user")
  BaseResponse updateGroupUsers(@PathVariable("groupId") Long groupId,
      @RequestParam("members") String members, @RequestParam("leaders") String leaders);

  /**
   * 获取群组关联用户,请求地址和上面是一样，这里使用的是Getmapping
   *
   * @param groupId
   * @return
   */
  @GetMapping("/facade/baseGroup/{groupId}/user")
  ObjectRestResponse<GroupUsersRespDTO> getGroupUsers(@PathVariable("groupId") Long groupId);


  /**
   * 变更群组关联的菜单
   *
   * @param groupId
   * @param menuTrees
   * @return
   */
  @PutMapping("/facade/baseGroup/{groupId}/authority/menu")
  BaseResponse updateAuthorityMenu(@PathVariable("groupId") Long groupId,
      @RequestParam("menuTrees") String menuTrees);

  /**
   * 获取群主关联的菜单
   *
   * @param groupId
   * @return
   */
  @GetMapping("/facade/baseGroup/{groupId}/list/authority/menu")
  ObjectRestResponse<List<AuthorityMenuTreeRespDTO>> listAuthorityMenus(
      @PathVariable("groupId") Long groupId);

  /**
   * 分配资源权限
   *
   * @param groupId
   * @param elementId
   * @return
   */
  @PutMapping("/facade/baseGroup/{groupId}/authority/element/add")
  BaseResponse updateAuthorityElement(@PathVariable("groupId") Long groupId,
      @RequestParam("elementId") Long elementId);

  /**
   * 移除资源权限
   *
   * @param groupId
   * @param elementId
   * @return
   */
  @DeleteMapping("/facade/baseGroup/{groupId}/authority/element/remove")
  BaseResponse removeAuthorityElement(@PathVariable("groupId") Long groupId,
      @RequestParam("elementId") Long elementId);

  /**
   * 获取群组关联的资源
   *
   * @param groupId
   * @return
   */
  @GetMapping("/facade/baseGroup/{groupId}/list/authority/element")
  ObjectRestResponse<List<Long>> listAuthorityElementIds(@PathVariable("groupId") Long groupId);


}
