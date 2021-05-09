package com.db.chaomaxs.managementweb.controller.positiontype;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;

import com.db.chaomaxs.managementweb.controller.positiontype.dto.PositionTypeAddDTO;
import com.db.chaomaxs.managementweb.controller.positiontype.dto.PositionTypeDTO;
import com.db.chaomaxs.managementweb.controller.positiontype.dto.PositionTypePageDTO;
import com.db.chaomaxs.managementweb.controller.positiontype.dto.PositionTypeUpdateDTO;
import com.db.chaomaxs.managementweb.controller.positiontype.vo.PositionTypeVO;
import com.db.chaomaxs.managementweb.manager.positiontype.PositionTypeManager;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 职务职位分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Api(value = "职务职位分类信息表", description = "职务职位分类信息表", tags = "PositionType")
@RestController
@RequestMapping("/rest/positionType")
public class PositionTypeController {

  @Autowired
  private PositionTypeManager positionTypeManager;

  /**
   * 添加数据
   *
   * @param addDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody PositionTypeAddDTO addDTO) {
    positionTypeManager.save(addDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param updateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody PositionTypeUpdateDTO updateDTO) {
    positionTypeManager.update(updateDTO);
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
    positionTypeManager.remove(id);
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
  public ObjectRestResponse<PositionTypeVO> getPositionTypeById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(positionTypeManager.getPositionTypeById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<PositionTypeVO>> listPositionTypes(
      @Valid @RequestBody PositionTypeDTO positionTypeDTO) {
    List<PositionTypeVO> list = positionTypeManager.listPositionTypes(positionTypeDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<PositionTypeVO> page(@RequestBody PositionTypePageDTO pageReqDTO) {
    return positionTypeManager.pagePositionType(pageReqDTO);
  }

}
