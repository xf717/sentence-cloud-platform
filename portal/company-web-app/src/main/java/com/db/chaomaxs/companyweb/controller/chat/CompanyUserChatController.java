package com.db.chaomaxs.companyweb.controller.chat;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyweb.controller.chat.dto.CompanyUserChatAddDTO;
import com.db.chaomaxs.companyweb.controller.chat.dto.CompanyUserChatPageDTO;
import com.db.chaomaxs.companyweb.controller.chat.vo.CompanyUserChatVO;
import com.db.chaomaxs.companyweb.manager.chat.CompanyUserChatManager;
import com.db.chaomaxs.companyweb.service.resume.vo.UserResumeInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业我的沟通
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "企业我的沟通", description = "企业我的沟通", tags = "CompanyUserChat")
@RestController
@RequestMapping("/rest/companyUserChat")
public class CompanyUserChatController {

  @Autowired
  private CompanyUserChatManager companyUserChatManager;

  /**
   * 添加数据
   *
   * @param companyUserChatAddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody CompanyUserChatAddDTO companyUserChatAddDTO) {
    companyUserChatManager.save(companyUserChatAddDTO);
    return BaseResponse.success("保存成功");
  }


  /**
   * 获取数据
   * @param id
   * @return
   */
  @ApiOperation(value = "获取对象数据", nickname = "get")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @GetMapping("/get/{id}")
  public ObjectRestResponse<CompanyUserChatVO> getCompanyUserChatById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(companyUserChatManager.getCompanyUserChatById(id));
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<UserResumeInfoVO> page(@RequestBody CompanyUserChatPageDTO pageReqDTO) {
    return companyUserChatManager.pageCompanyUserChat(pageReqDTO);
  }

}
