package com.db.chaomaxs.companyweb.controller.position;


import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyweb.controller.position.dto.PositionTypeAddDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.PositionTypeDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.PositionTypePageDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.PositionTypeUpdateDTO;
import com.db.chaomaxs.companyweb.controller.position.vo.PositionTypeTreeVO;
import com.db.chaomaxs.companyweb.controller.position.vo.PositionTypeVO;
import com.db.chaomaxs.companyweb.manager.position.PositionTypeManager;
import com.db.chaomaxs.positionservice.constant.CommonConstants;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 职务职位分类信息表
 *
 * @author ding
 * @date 2021-04-06 17:45:09
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
    List<PositionTypeTreeVO> list = positionTypeManager.listPositionTypes(positionTypeDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<PositionTypeVO> page(@RequestBody PositionTypePageDTO pageReqDTO) {
    return positionTypeManager.pagePositionType(pageReqDTO);
  }


  @ApiOperation(value = "根据参数查询所有可显示分类（树型）,不分页", nickname = "listDisplayPositionType")
  @PostMapping("/list/display/position")
  public ObjectRestResponse<List<PositionTypeVO>> listDisplayPositionType(
      @Valid @RequestBody PositionTypeDTO positionTypeDTO) {
    List<PositionTypeTreeVO> list = positionTypeManager.listDisplayPositionType(positionTypeDTO);
    return ObjectRestResponse.success(list);
  }


  @ApiOperation(value = "根据parentId查询数据,不分页,parentId不传默认获取顶级分类", nickname = "listPositionType")
  @GetMapping("/list/position")
  public ObjectRestResponse<List<PositionTypeVO>> listPositionType(
      @RequestParam(value = "parentId", required = false) Long parentId) {
    if (null == parentId) {
      parentId = CommonConstants.TREE_TOP_PARENT_ID;
    }
    List<PositionTypeVO> list = positionTypeManager.listPositionTypeByParentId(parentId);
    return ObjectRestResponse.success(list);
  }

}
