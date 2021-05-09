package com.github.xf717.managementweb.controller.dict;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.managementweb.controller.dict.dto.DataDictionaryItemAddDTO;
import com.github.xf717.managementweb.controller.dict.dto.DataDictionaryItemDTO;
import com.github.xf717.managementweb.controller.dict.dto.DataDictionaryItemUpdateDTO;
import com.github.xf717.managementweb.controller.dict.vo.DataDictionaryItemVO;
import com.github.xf717.managementweb.manager.dict.DataDictionaryItemManager;
import com.github.xf717.security.auth.client.annotation.IgnoreUserToken;
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
 * 数据字典项信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Api(value = "数据字典项信息表", description = "数据字典项信息表", tags = "DataDictionaryItem")
@RestController
@RequestMapping("/rest/dataDictionaryItem")
public class DataDictionaryItemController {

  @Autowired
  private DataDictionaryItemManager dataDictionaryItemManager;

  /**
   * 添加数据
   *
   * @param addDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody DataDictionaryItemAddDTO addDTO) {
    dataDictionaryItemManager.save(addDTO);
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
  public BaseResponse update(@Valid @RequestBody DataDictionaryItemUpdateDTO updateDTO) {
    dataDictionaryItemManager.update(updateDTO);
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
    dataDictionaryItemManager.remove(id);
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
  public ObjectRestResponse<DataDictionaryItemVO> getDataDictionaryItemById(
      @PathVariable("id") Long id) {
    return ObjectRestResponse.success(dataDictionaryItemManager.getDataDictionaryItemById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<DataDictionaryItemVO>> listDataDictionaryItems(
      @Valid @RequestBody DataDictionaryItemDTO dataDictionaryItemDTO) {
    List<DataDictionaryItemVO> list = dataDictionaryItemManager
        .listDataDictionaryItems(dataDictionaryItemDTO);
    return ObjectRestResponse.success(list);
  }


  @ApiOperation(value = "获取字典类型编号", nickname = "get")
  @GetMapping("/get/{dictName}/code")
  @IgnoreUserToken
  public ObjectRestResponse getDictCode(@PathVariable("dictName") String dictName) {
    return dataDictionaryItemManager.getInitials(dictName);
  }

}
