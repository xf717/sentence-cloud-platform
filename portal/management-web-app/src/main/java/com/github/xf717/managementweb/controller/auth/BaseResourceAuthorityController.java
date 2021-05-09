package com.github.xf717.managementweb.controller.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.auth.dto.BaseResourceAuthorityAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseResourceAuthorityDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseResourceAuthorityPageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseResourceAuthorityUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.BaseResourceAuthorityVO;
import com.github.xf717.managementweb.manager.auth.BaseResourceAuthorityManager;
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
@Api(value = "", description = "", tags = "BaseResourceAuthority")
@RestController
@RequestMapping("/rest/baseResourceAuthority")
public class BaseResourceAuthorityController {

  @Autowired
  private BaseResourceAuthorityManager baseResourceAuthorityManager;

  /**
   * 添加数据
   *
   * @param baseResourceAuthorityAddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(
      @Valid @RequestBody BaseResourceAuthorityAddDTO baseResourceAuthorityAddDTO) {
    baseResourceAuthorityManager.save(baseResourceAuthorityAddDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param baseResourceAuthorityUpdateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(
      @Valid @RequestBody BaseResourceAuthorityUpdateDTO baseResourceAuthorityUpdateDTO) {
    baseResourceAuthorityManager.update(baseResourceAuthorityUpdateDTO);
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
    baseResourceAuthorityManager.remove(id);
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
  public ObjectRestResponse<BaseResourceAuthorityVO> getBaseResourceAuthorityById(
      @PathVariable("id") Long id) {
    return ObjectRestResponse
        .success(baseResourceAuthorityManager.getBaseResourceAuthorityById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<BaseResourceAuthorityVO>> listBaseResourceAuthoritys(
      @Valid @RequestBody BaseResourceAuthorityDTO baseResourceAuthorityDTO) {
    List<BaseResourceAuthorityVO> list = baseResourceAuthorityManager
        .listBaseResourceAuthoritys(baseResourceAuthorityDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<BaseResourceAuthorityVO> page(
      @RequestBody BaseResourceAuthorityPageDTO pageReqDTO) {
    return baseResourceAuthorityManager.pageBaseResourceAuthority(pageReqDTO);
  }

}
