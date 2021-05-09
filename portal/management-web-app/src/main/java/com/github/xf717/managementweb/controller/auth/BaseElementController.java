package com.github.xf717.managementweb.controller.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.auth.dto.BaseElementAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseElementDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseElementPageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseElementUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.BaseElementVO;
import com.github.xf717.managementweb.manager.auth.BaseElementManager;
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
@Api(value = "", description = "", tags = "BaseElement")
@RestController
@RequestMapping("/rest/baseElement")
public class BaseElementController {

  @Autowired
  private BaseElementManager baseElementManager;

  /**
   * 添加数据
   *
   * @param baseElementAddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody BaseElementAddDTO baseElementAddDTO) {
    baseElementManager.save(baseElementAddDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param baseElementUpdateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody BaseElementUpdateDTO baseElementUpdateDTO) {
    baseElementManager.update(baseElementUpdateDTO);
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
    baseElementManager.remove(id);
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
  public ObjectRestResponse<BaseElementVO> getBaseElementById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(baseElementManager.getBaseElementById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<BaseElementVO>> listBaseElements(
      @Valid @RequestBody BaseElementDTO baseElementDTO) {
    List<BaseElementVO> list = baseElementManager.listBaseElements(baseElementDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<BaseElementVO> page(@RequestBody BaseElementPageDTO pageReqDTO) {
    return baseElementManager.pageBaseElement(pageReqDTO);
  }

  @ApiOperation(value = "获取用户菜单资源", nickname = "getAuthorityMenuElementByUserId")
  @GetMapping("/user")
  public ObjectRestResponse<List<BaseElementVO>> getAuthorityMenuElementByUserId() {
    return new ObjectRestResponse<List<BaseElementVO>>()
        .data(baseElementManager.getAuthorityElementByUserId());
  }

  @ApiOperation(value = "获取用户菜单资源", nickname = "getAuthorityMenuElementByUserId")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @GetMapping("/user/menu")
  public ObjectRestResponse<List<BaseElementVO>> getAuthorityMenuElementByUserId(Long menuId) {
    return new ObjectRestResponse<List<BaseElementVO>>()
        .data(baseElementManager.getAuthorityMenuElementByUserId(menuId));
  }

}
