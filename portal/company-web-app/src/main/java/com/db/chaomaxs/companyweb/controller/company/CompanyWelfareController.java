package com.db.chaomaxs.companyweb.controller.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyWelfareAddDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyWelfareUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyWelfareInfoVO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyWelfareVO;
import com.db.chaomaxs.companyweb.manager.company.CompanyWelfareManager;
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
 * 公司福利
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "公司福利", description = "公司福利", tags = "CompanyWelfare")
@RestController
@RequestMapping("/rest/companyWelfare")
public class CompanyWelfareController {

  @Autowired
  private CompanyWelfareManager companyWelfareManager;

  /**
   * 自定义福利类型保存
   * @param companyWelfareAddDTO
   * @return
   */
  @ApiOperation(value = "自定义福利类型保存", produces = "application/json", nickname = "customTypeSave")
  @PostMapping("/custom-type/save")
  public BaseResponse customTypeSave(@Valid @RequestBody CompanyWelfareAddDTO companyWelfareAddDTO) {
    companyWelfareManager.customTypeSave(companyWelfareAddDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param companyWelfareUpdateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody CompanyWelfareUpdateDTO companyWelfareUpdateDTO) {
    companyWelfareManager.update(companyWelfareUpdateDTO);
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
    companyWelfareManager.remove(id);
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
  public ObjectRestResponse<CompanyWelfareVO> getCompanyWelfareById(
      @PathVariable("id") Long id) {
    return ObjectRestResponse.success(companyWelfareManager.getCompanyWelfareById(id));
  }

  @ApiOperation(value = "获取公司福利类型", nickname = "getCompanyWelfare")
  @GetMapping("/get/welfareType")
  public ObjectRestResponse<CompanyWelfareInfoVO> getCompanyWelfare() {
    return ObjectRestResponse.success(companyWelfareManager.getCompanyWelfare());
  }

  @ApiOperation(value = "获取所有福利类型", nickname = "listAllWelfare")
  @GetMapping("/list/all-welfare")
  public ObjectRestResponse<List<CompanyWelfareVO>> listAllWelfare() {
    return ObjectRestResponse.success(companyWelfareManager.listAllWelfare());
  }

  @ApiOperation(value = "保存福利类型", nickname = "saveChooseWelfare")
  @GetMapping("/save/welfareType")
  public BaseResponse saveChooseWelfare(@RequestBody List<CompanyWelfareAddDTO> companyWelfareAddDTOs) {
    companyWelfareManager.saveChooseWelfare(companyWelfareAddDTOs);
    return BaseResponse.success("保存成功！");
  }


}
