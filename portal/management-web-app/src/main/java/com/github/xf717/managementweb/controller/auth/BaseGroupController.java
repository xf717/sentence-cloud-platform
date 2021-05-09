package com.github.xf717.managementweb.controller.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupPageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.AuthorityMenuTreeVO;
import com.github.xf717.managementweb.controller.auth.vo.BaseGroupVO;
import com.github.xf717.managementweb.controller.auth.vo.GroupTreeVO;
import com.github.xf717.managementweb.controller.auth.vo.GroupUsersVO;
import com.github.xf717.managementweb.manager.auth.BaseGroupManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Api(value = "", description = "", tags = "BaseGroup")
@RestController
@RequestMapping("/rest/baseGroup")
public class BaseGroupController {

  @Autowired
  private BaseGroupManager baseGroupManager;

  /**
   * 添加数据
   *
   * @param baseGroupAddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody BaseGroupAddDTO baseGroupAddDTO) {
    baseGroupManager.save(baseGroupAddDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param baseGroupUpdateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody BaseGroupUpdateDTO baseGroupUpdateDTO) {
    baseGroupManager.update(baseGroupUpdateDTO);
    return BaseResponse.success("更新成功");
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "删除数据", nickname = "remove")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @DeleteMapping("/remove/{id}")
  public BaseResponse remove(@PathVariable("id") Long id) {
    baseGroupManager.remove(id);
    return BaseResponse.success("删除成功");
  }

  /**
   * 获取数据
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "获取对象数据", nickname = "get")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @GetMapping("/get/{id}")
  public ObjectRestResponse<BaseGroupVO> getBaseGroupById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(baseGroupManager.getBaseGroupById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<BaseGroupVO>> listBaseGroups(
      @Valid @RequestBody BaseGroupDTO baseGroupDTO) {
    List<BaseGroupVO> list = baseGroupManager.listBaseGroups(baseGroupDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<BaseGroupVO> page(@RequestBody BaseGroupPageDTO pageReqDTO) {
    return baseGroupManager.pageBaseGroup(pageReqDTO);
  }

  /**
   * 修改组用户
   *
   * @param id
   * @param members
   * @param leaders
   * @return
   */
  @ApiOperation(value = "修改组用户", nickname = "updateUsers")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "groupId", dataType = "Long", paramType = "path", required = true),
      @ApiImplicitParam(name = "members", dataType = "String", paramType = "query", required = true),
      @ApiImplicitParam(name = "leaders", dataType = "String", paramType = "query", required = true)
  })
  @PutMapping(value = "/{groupId}/user")
  public BaseResponse updateUsers(@PathVariable Long groupId, String members, String leaders) {
    baseGroupManager.updateGroupUsers(groupId, members, leaders);
    return BaseResponse.success("成功");
  }

  @ApiOperation(value = "获取群组关联用户", nickname = "getUsers")
  @ApiImplicitParam(name = "groupId", dataType = "Long", paramType = "path", required = true)
  @GetMapping(value = "/{groupId}/user")
  public ObjectRestResponse<GroupUsersVO> getUsers(@PathVariable Long groupId) {
    return new ObjectRestResponse<>().data(baseGroupManager.getGroupUsers(groupId));
  }

  /**
   * 变更群组关联的菜单
   *
   * @param groupId
   * @param menuTrees
   * @return
   */
  @ApiOperation(value = "变更群组关联的菜单", nickname = "updateMenuAuthority")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "groupId", dataType = "Long", paramType = "path", required = true),
      @ApiImplicitParam(name = "menuTrees", dataType = "String", paramType = "query", required = true)
  })
  @PutMapping(value = "/{groupId}/authority/menu")
  public BaseResponse updateMenuAuthority(@PathVariable Long groupId, String menuTrees) {
    baseGroupManager.updateAuthorityMenu(groupId, menuTrees);
    return BaseResponse.success("成功");
  }

  /**
   * 获取组权限菜单
   *
   * @param groupId
   * @return
   */
  @ApiOperation(value = "获取组权限菜单", nickname = "listAuthorityMenus")
  @ApiImplicitParam(name = "groupId", dataType = "Long", paramType = "path", required = true)
  @GetMapping(value = "/{groupId}/authority/menu")
  public ObjectRestResponse<List<AuthorityMenuTreeVO>> listAuthorityMenus(
      @PathVariable Long groupId) {
    return new ObjectRestResponse().data(baseGroupManager.listAuthorityMenus(groupId));
  }

  /**
   * 分配资源权限
   *
   * @param groupId
   * @param elementId
   */
  @ApiOperation(value = "分配资源权限", nickname = "addElementAuthority")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "groupId", dataType = "Long", paramType = "path", required = true),
      @ApiImplicitParam(name = "elementId", dataType = "Long", paramType = "query", required = true)
  })
  @PutMapping(value = "/{groupId}/authority/element/add")
  public BaseResponse addElementAuthority(@PathVariable Long groupId, Long elementId) {
    baseGroupManager.updateAuthorityElement(groupId, elementId);
    return BaseResponse.success("成功");
  }

  /**
   * 移除资源权限
   *
   * @param groupId
   * @param elementId
   * @return
   */
  @ApiOperation(value = "移除资源权限", nickname = "removeAuthorityElement")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "groupId", dataType = "Long", paramType = "path", required = true),
      @ApiImplicitParam(name = "elementId", dataType = "Long", paramType = "query", required = true)
  })
  @PutMapping(value = "/{groupId}/authority/element/remove")
  public BaseResponse removeAuthorityElement(@PathVariable Long groupId, Long elementId) {
    baseGroupManager.removeAuthorityElement(groupId, elementId);
    return BaseResponse.success("成功");
  }

  /**
   * 获取群组关联的资源
   *
   * @param groupId
   * @return
   */
  @ApiOperation(value = "获取群组关联的资源", nickname = "listAuthorityElementIds")
  @ApiImplicitParam(name = "groupId", dataType = "int", paramType = "path", required = true)
  @GetMapping(value = "/{groupId}/authority/element")
  public ObjectRestResponse<List<Long>> listAuthorityElementIds(@PathVariable Long groupId) {
    return new ObjectRestResponse().data(baseGroupManager.listAuthorityElementIds(groupId));
  }

  /**
   * @param name
   * @param groupType
   * @return
   */
  @ApiOperation(value = "获取组树", nickname = "tree")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "name", dataType = "String", paramType = "query", required = true),
      @ApiImplicitParam(name = "groupType", dataType = "String", paramType = "query", required = true)
  })
  @GetMapping(value = "/tree")
  public ObjectRestResponse<List<GroupTreeVO>> tree(String name,
      Long groupType) {
    return new ObjectRestResponse().data(baseGroupManager.tree(name, groupType));
  }


}
