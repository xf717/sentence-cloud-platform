package com.github.xf717.managementweb.controller.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.auth.dto.BaseMenuAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseMenuDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseMenuPageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseMenuUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.AuthorityMenuTreeVO;
import com.github.xf717.managementweb.controller.auth.vo.BaseMenuVO;
import com.github.xf717.managementweb.controller.auth.vo.MenuTreeVO;
import com.github.xf717.managementweb.manager.auth.BaseMenuManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
@Api(value = "", description = "", tags = "BaseMenu")
@RestController
@RequestMapping("/rest/baseMenu")
public class BaseMenuController {

  @Autowired
  private BaseMenuManager baseMenuManager;

  /**
   * 添加数据
   *
   * @param baseMenuAddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody BaseMenuAddDTO baseMenuAddDTO) {
    baseMenuManager.save(baseMenuAddDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param baseMenuUpdateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody BaseMenuUpdateDTO baseMenuUpdateDTO) {
    baseMenuManager.update(baseMenuUpdateDTO);
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
    baseMenuManager.remove(id);
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
  public ObjectRestResponse<BaseMenuVO> getBaseMenuById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(baseMenuManager.getBaseMenuById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<BaseMenuVO>> listBaseMenus(
      @Valid @RequestBody BaseMenuDTO baseMenuDTO) {
    List<BaseMenuVO> list = baseMenuManager.listBaseMenus(baseMenuDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<BaseMenuVO> page(@RequestBody BaseMenuPageDTO pageReqDTO) {
    return baseMenuManager.pageBaseMenu(pageReqDTO);
  }

  @GetMapping(value = "/tree")
  @ApiOperation(value = "获取菜单tree", nickname = "getTree")
  public ObjectRestResponse<List<MenuTreeVO>> getTree(String title) {
    return new ObjectRestResponse<>()
        .data(baseMenuManager.getTree(title));
  }

  @GetMapping(value = "/system")
  @ApiOperation(value = "获取菜单tree", nickname = "getSystem")
  public ObjectRestResponse<List<BaseMenuVO>> getSystem() {
    return new ObjectRestResponse<>()
        .data(baseMenuManager.getSystem());
  }

  @GetMapping(value = "/menuTree")
  @ApiOperation(value = "获取菜单tree", nickname = "listMenus")
  public ObjectRestResponse<List<MenuTreeVO>> listMenus(Long parentId) {
    return new ObjectRestResponse<>()
        .data(baseMenuManager.listMenus(parentId));
  }

  @GetMapping(value = "/authorityTree")
  @ApiOperation(value = "获取菜单tree", nickname = "listAuthorityMenu")
  public ObjectRestResponse<List<AuthorityMenuTreeVO>> listAuthorityMenu() {
    return new ObjectRestResponse<>()
        .data(baseMenuManager.listAuthorityMenu());
  }

  @GetMapping(value = "/user/authorityTree")
  @ApiOperation(value = "获取用户可访问权限菜单", nickname = "listUserAuthorityMenus")
  public ObjectRestResponse<List<MenuTreeVO>> listUserAuthorityMenus(Long parentId) {
    return new ObjectRestResponse<>()
        .data(baseMenuManager.listUserAuthorityMenus(parentId));
  }

  @GetMapping(value = "/user/system")
  @ApiOperation(value = "获取用户可访问系统", nickname = "listUserAuthoritySystem")
  public ObjectRestResponse<List<MenuTreeVO>> listUserAuthoritySystems() {
    return new ObjectRestResponse<>()
        .data(baseMenuManager.listUserAuthoritySystem());
  }


}
