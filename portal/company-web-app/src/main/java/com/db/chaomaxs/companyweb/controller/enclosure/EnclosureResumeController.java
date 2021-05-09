package com.db.chaomaxs.companyweb.controller.enclosure;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyweb.controller.enclosure.dto.EnclosureResumeAddDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.dto.EnclosureResumeDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.dto.EnclosureResumePageDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.dto.EnclosureResumeUpdateDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.vo.EnclosureResumeVO;
import com.db.chaomaxs.companyweb.manager.enclosure.EnclosureResumeManager;
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
 * 企业附件简历
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "企业附件简历", description = "企业附件简历", tags = "EnclosureResume")
@RestController
@RequestMapping("/rest/enclosureResume")
public class EnclosureResumeController {

  @Autowired
  private EnclosureResumeManager enclosureResumeManager;

  /**
   * 添加数据
   *
   * @param AddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody EnclosureResumeAddDTO enclosureResumeAddDTO) {
    enclosureResumeManager.save(enclosureResumeAddDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param UpdateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(
      @Valid @RequestBody EnclosureResumeUpdateDTO enclosureResumeUpdateDTO) {
    enclosureResumeManager.update(enclosureResumeUpdateDTO);
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
    enclosureResumeManager.remove(id);
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
  public ObjectRestResponse<EnclosureResumeVO> getEnclosureResumeById(
      @PathVariable("id") Long id) {
    return ObjectRestResponse.success(enclosureResumeManager.getEnclosureResumeById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<EnclosureResumeVO>> listEnclosureResumes(
      @Valid @RequestBody EnclosureResumeDTO enclosureResumeDTO) {
    List<EnclosureResumeVO> list = enclosureResumeManager.listEnclosureResumes(enclosureResumeDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<EnclosureResumeVO> page(
      @RequestBody EnclosureResumePageDTO pageReqDTO) {
    return enclosureResumeManager.pageEnclosureResume(pageReqDTO);
  }

}
