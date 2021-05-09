package com.db.chaomaxs.managementweb.controller.auth;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupTypeAddDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupTypeDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupTypePageDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupTypeUpdateDTO;
import com.db.chaomaxs.managementweb.controller.auth.vo.BaseGroupTypeVO;
import com.db.chaomaxs.managementweb.manager.auth.BaseGroupTypeManager;
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
@Api(value = "", description = "", tags = "BaseGroupType")
@RestController
@RequestMapping("/rest/baseGroupType")
public class BaseGroupTypeController {

  @Autowired
  private BaseGroupTypeManager baseGroupTypeManager;

  /**
   * 添加数据
   *
   * @param baseGroupTypeAddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody BaseGroupTypeAddDTO baseGroupTypeAddDTO) {
    baseGroupTypeManager.save(baseGroupTypeAddDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param baseGroupTypeUpdateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody BaseGroupTypeUpdateDTO baseGroupTypeUpdateDTO) {
    baseGroupTypeManager.update(baseGroupTypeUpdateDTO);
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
    baseGroupTypeManager.remove(id);
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
  public ObjectRestResponse<BaseGroupTypeVO> getBaseGroupTypeById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(baseGroupTypeManager.getBaseGroupTypeById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<BaseGroupTypeVO>> listBaseGroupTypes(
      @Valid @RequestBody BaseGroupTypeDTO baseGroupTypeDTO) {
    List<BaseGroupTypeVO> list = baseGroupTypeManager.listBaseGroupTypes(baseGroupTypeDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<BaseGroupTypeVO> page(@RequestBody BaseGroupTypePageDTO pageReqDTO) {
    return baseGroupTypeManager.pageBaseGroupType(pageReqDTO);
  }

}
