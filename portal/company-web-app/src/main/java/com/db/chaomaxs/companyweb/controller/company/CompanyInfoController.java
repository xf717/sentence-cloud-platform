package com.db.chaomaxs.companyweb.controller.company;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyInfoUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyRegisterReqDto;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyBaseInfoVO;
import com.db.chaomaxs.companyweb.manager.company.CompanyInfoManager;
import com.db.chaomaxs.security.auth.client.annotation.IgnoreUserToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业_基础信息
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "企业_基础信息", description = "企业_基础信息", tags = "企业_基础信息")
@RestController
@RequestMapping("/rest/companyInfo")
public class CompanyInfoController {

  @Autowired
  private CompanyInfoManager companyInfoManager;

  /**
   * 更新数据
   *
   * @param companyInfoUpdateDTO
   * @return
   */
  @ApiOperation(value = "更新公司基本信息", produces = "application/json", nickname = "update")
  @PutMapping("/update")
  public BaseResponse update(@Valid @RequestBody CompanyInfoUpdateDTO companyInfoUpdateDTO) {
    companyInfoManager.update(companyInfoUpdateDTO);
    return BaseResponse.success("更新成功");
  }

  /**
   * 获取公司主页基本信息
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "获取公司主页基本信息", nickname = "get")
  @GetMapping("/get")
  public ObjectRestResponse<CompanyBaseInfoVO> getCompanyInfoById() {
    return ObjectRestResponse.success(companyInfoManager.getCompanyInfoById(BaseContextHandler.getCompanyId()));
  }

  @ApiOperation(value = "企业pc端注册", nickname = "register")
  @PostMapping("/register")
  public BaseResponse register(@RequestBody CompanyRegisterReqDto companyRegisterReqDto) {
    companyInfoManager.register(companyRegisterReqDto);
    return BaseResponse.success("注册成功");
  }
}
