package com.db.chaomaxs.companyweb.controller.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyColleagueInfoDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyColleaguePageDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyColleagueTransferReqDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyColleagueUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyColleagueVO;
import com.db.chaomaxs.companyweb.manager.company.CompanyColleagueManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业_同事
 *
 * @author hlf
 * @date 2021-03-26 10:18:33
 */
@Api(value = "企业_同事", tags = "企业_同事")
@RestController
@RequestMapping("/rest/companyColleague")
public class CompanyColleagueController {

  @Autowired
  private CompanyColleagueManager companyColleagueManager;

  @ApiOperation(value = "企业_同事分页列表", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<CompanyColleagueVO> colleaguePage(@RequestBody CompanyColleaguePageDTO companyRegisterReqDto) {
    return companyColleagueManager.colleaguePage(companyRegisterReqDto);
  }

  @ApiOperation(value = "企业_同事绑定状态修改", nickname = "bindingStateUpdate")
  @PostMapping("/update/binding-state")
  public BaseResponse bindingStateUpdate(@RequestBody CompanyColleagueUpdateDTO companyColleagueUpdateDTO) {
    companyColleagueManager.updateBindingState(companyColleagueUpdateDTO);
    return BaseResponse.success("更新成功！");
  }

  @ApiOperation(value = "获取所有同事", nickname = "getAllBindingUser")
  @GetMapping("/get-all-bindingUser")
  public ObjectRestResponse<List<CompanyColleagueInfoDTO>> getAllBindingUser() {
    return companyColleagueManager.getAllBindingUser();
  }

  @ApiOperation(value = "企业_同事管理员身份转移", nickname = "managerTransfer")
  @PostMapping("/manager-transfer")
  public BaseResponse managerTransfer(@RequestBody CompanyColleagueTransferReqDTO companyColleagueTransferReqDTO) {
    companyColleagueManager.managerTransfer(companyColleagueTransferReqDTO);
    return BaseResponse.success("转移成功！");
  }

  @ApiOperation(value = "企业_同事交接", nickname = "bindingStateUpdate")
  @PostMapping("/handover")
  public BaseResponse handover(@RequestBody CompanyColleagueTransferReqDTO companyColleagueTransferReqDTO) {
    companyColleagueManager.handover(companyColleagueTransferReqDTO);
    return BaseResponse.success("交接成功！");
  }


}
