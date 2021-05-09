package com.github.xf717.managementweb.controller.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.auth.dto.BaseUserAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseUserDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseUserPageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseUserUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.BaseMenuVO;
import com.github.xf717.managementweb.controller.auth.vo.BaseUserVO;
import com.github.xf717.managementweb.controller.auth.vo.FrontUserV2VO;
import com.github.xf717.managementweb.controller.auth.vo.FrontUserVO;
import com.github.xf717.managementweb.controller.auth.vo.MenuTreeVO;
import com.github.xf717.managementweb.manager.auth.BaseMenuManager;
import com.github.xf717.managementweb.manager.auth.BaseUserManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Api(value = "", description = "", tags = "BaseUser")
@RestController
@RequestMapping("/rest/baseUser")
public class BaseUserController {

  @Autowired
  private BaseUserManager baseUserManager;

  @Autowired
  private BaseMenuManager baseMenuManager;


  /**
   * 添加数据
   *
   * @param baseUserAddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody BaseUserAddDTO baseUserAddDTO) {
    baseUserManager.save(baseUserAddDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param baseUserUpdateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody BaseUserUpdateDTO baseUserUpdateDTO) {
    baseUserManager.update(baseUserUpdateDTO);
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
    baseUserManager.remove(id);
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
  public ObjectRestResponse<BaseUserVO> getBaseUserById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(baseUserManager.getBaseUserById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<BaseUserVO>> listBaseUsers(
      @Valid @RequestBody BaseUserDTO baseUserDTO) {
    List<BaseUserVO> list = baseUserManager.listBaseUsers(baseUserDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<BaseUserVO> page(@RequestBody BaseUserPageDTO pageReqDTO) {
    return baseUserManager.pageBaseUser(pageReqDTO);
  }

  @GetMapping(value = "/front/info")
  public ObjectRestResponse<FrontUserVO> getUserInfo(String token) {
    FrontUserVO userInfo = baseUserManager.getUserInfo(token);
    if (userInfo == null) {
      return ObjectRestResponse.failure(401, "找不到用户");
    } else {
      return new ObjectRestResponse<>().data(userInfo);
    }
  }

  @GetMapping(value = "/v2/front/info")
  public ObjectRestResponse<FrontUserV2VO> getUserInfoV2() {
    FrontUserV2VO userInfo = baseUserManager.getUserInfoV2();
    return new ObjectRestResponse<FrontUserV2VO>().data(userInfo);
  }

  @GetMapping(value = "/front/menus")
  public ObjectRestResponse<List<MenuTreeVO>> getMenusByUsername(String token) {
    return new ObjectRestResponse<>().data(baseUserManager.getMenusByUsername(token));
  }

  @GetMapping(value = "/front/menu/all")
  public ObjectRestResponse<List<BaseMenuVO>> getAllMenus() {
    return new ObjectRestResponse<>().data(baseMenuManager.listAllMenus());
  }


}
