package com.db.chaomaxs.companyweb.controller.audit;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyweb.controller.audit.dto.CompanyAuditRecordAddDTO;
import com.db.chaomaxs.companyweb.controller.audit.dto.CompanyAuditRecordDTO;
import com.db.chaomaxs.companyweb.controller.audit.dto.CompanyAuditRecordPageDTO;
import com.db.chaomaxs.companyweb.controller.audit.dto.CompanyAuditRecordUpdateDTO;
import com.db.chaomaxs.companyweb.controller.audit.vo.CompanyAuditRecordVO;
import com.db.chaomaxs.companyweb.manager.audit.CompanyAuditRecordManager;
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
 * 公司_审核记录信息表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "公司_审核记录信息表", description = "公司_审核记录信息表", tags = "CompanyAuditRecord")
@RestController
@RequestMapping("/rest/companyAuditRecord")
public class CompanyAuditRecordController {

  @Autowired
  private CompanyAuditRecordManager companyAuditRecordManager;

  /**
   * 添加数据
   *
   * @param companyAuditRecordAddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody CompanyAuditRecordAddDTO addDTO) {
    companyAuditRecordManager.save(addDTO);
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
  public BaseResponse update(
      @Valid @RequestBody CompanyAuditRecordUpdateDTO updateDTO) {
    companyAuditRecordManager.update(updateDTO);
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
    companyAuditRecordManager.remove(id);
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
  public ObjectRestResponse<CompanyAuditRecordVO> getCompanyAuditRecordById(
      @PathVariable("id") Long id) {
    return ObjectRestResponse.success(companyAuditRecordManager.getCompanyAuditRecordById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<CompanyAuditRecordVO>> listCompanyAuditRecords(
      @Valid @RequestBody CompanyAuditRecordDTO companyAuditRecordDTO) {
    List<CompanyAuditRecordVO> list = companyAuditRecordManager
        .listCompanyAuditRecords(companyAuditRecordDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<CompanyAuditRecordVO> page(
      @RequestBody CompanyAuditRecordPageDTO pageReqDTO) {
    return companyAuditRecordManager.pageCompanyAuditRecord(pageReqDTO);
  }

}
