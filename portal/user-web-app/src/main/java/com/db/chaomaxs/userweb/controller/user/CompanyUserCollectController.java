package com.db.chaomaxs.userweb.controller.user;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.security.auth.client.annotation.IgnoreUserToken;
import com.db.chaomaxs.userweb.controller.user.dto.CompanyUserCollectPageDTO;
import com.db.chaomaxs.userweb.controller.user.vo.CompanyUserCollectVO;
import com.db.chaomaxs.userweb.manager.user.CompanyUserCollectManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 企业_用户_收藏
 *
 * @author momo
 * @date 2021-03-26 10:18:33
 */
@Api(value = "企业_用户_收藏", description = "企业_用户_收藏", tags = "CompanyUserCollect")
@RestController
@RequestMapping("/rest/companyUserCollect")
public class CompanyUserCollectController {

  @Autowired
  private CompanyUserCollectManager companyUserCollectManager;


  /**
   * 获取数据
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "获取对象数据", nickname = "get")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @GetMapping("/get/{id}")
  public ObjectRestResponse<CompanyUserCollectVO> getCompanyUserCollectById(
      @PathVariable("id") Long id) {
    return ObjectRestResponse.success(companyUserCollectManager.getCompanyUserCollectById(id));
  }


  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<CompanyUserCollectVO> page(
      @RequestBody CompanyUserCollectPageDTO pageReqDTO) {
    return companyUserCollectManager.pageCompanyUserCollect(pageReqDTO);
  }

}
