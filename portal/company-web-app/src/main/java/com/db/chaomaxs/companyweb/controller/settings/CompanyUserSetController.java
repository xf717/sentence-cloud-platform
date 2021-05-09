package com.db.chaomaxs.companyweb.controller.settings;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyweb.controller.settings.dto.CompanyUserSetAddDTO;
import com.db.chaomaxs.companyweb.controller.settings.dto.CompanyUserSetUpdateDTO;
import com.db.chaomaxs.companyweb.controller.settings.vo.CompanyUserSetVO;
import com.db.chaomaxs.companyweb.manager.settings.CompanyUserSetManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业我的设置
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Api(value = "企业我的设置", description = "企业我的设置", tags = "CompanyUserSet")
@RestController
@RequestMapping("/rest/companyUserSet")
public class CompanyUserSetController {

  @Autowired
  private CompanyUserSetManager companyUserSetManager;

  /**
   * 添加数据
   *
   * @param companyUserSetAddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody CompanyUserSetAddDTO companyUserSetAddDTO) {
    companyUserSetManager.save(companyUserSetAddDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param companyUserSetUpdateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody CompanyUserSetUpdateDTO companyUserSetUpdateDTO) {
    companyUserSetManager.update(companyUserSetUpdateDTO);
    return BaseResponse.success("更新成功");
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
  public ObjectRestResponse<CompanyUserSetVO> getCompanyUserSetById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(companyUserSetManager.getCompanyUserSetById(id));
  }


}
