package com.github.xf717.userweb.controller.position;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableData;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.security.auth.client.annotation.IgnoreUserToken;
import com.github.xf717.userweb.controller.position.dto.CompanyPositionPageReqDTO;
import com.github.xf717.userweb.controller.position.dto.SearchPositionPageReqDTO;
import com.github.xf717.userweb.controller.position.vo.CompanyInfoDetailVO;
import com.github.xf717.userweb.controller.position.vo.CompanyPositionVO;
import com.github.xf717.userweb.controller.position.vo.SearchPositionVO;
import com.github.xf717.userweb.manager.position.PositionManager;
import com.github.xf717.userweb.service.postition.vo.PositionDetailVO;
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
 * 职位
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/28 13:37
 */
@Api(value = "职位", description = "职位", tags = "职位")
@RestController
@RequestMapping("/rest/position")
public class PositionController {

  @Autowired
  private PositionManager positionManager;

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "pageSearchPosition")
  @PostMapping("/search")
  @IgnoreUserToken
  public TableResultResponse<SearchPositionVO> pageSearchPosition(
      @RequestBody SearchPositionPageReqDTO positionSearchReq) {
    TableData<SearchPositionVO> tableData = positionManager.pageSearchPosition(positionSearchReq);
    return new TableResultResponse<>(tableData);
  }

  @ApiOperation(value = "获取职位详情", nickname = "getPositionDetail")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @GetMapping("/get/{id}")
  public ObjectRestResponse<PositionDetailVO> getPositionDetail(@PathVariable("id") Long id) {
    PositionDetailVO positionDetail = this.positionManager.getPositionDetail(id);
    return ObjectRestResponse.success(positionDetail);
  }

  @ApiOperation(value = "获取公司详情", nickname = "getCompanyInfoDetailById")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @GetMapping("/get/companyInfo/{id}")
  public ObjectRestResponse<CompanyInfoDetailVO> getCompanyInfoDetailById(
      @PathVariable("id") Long id) {
    CompanyInfoDetailVO companyInfoDetail = positionManager.getCompanyInfoDetailById(id);
    return ObjectRestResponse.success(companyInfoDetail);
  }

  @ApiOperation(value = "根据公司id,获取职位数据", nickname = "pageByCompanyUserId")
  @PostMapping("/page-by-company")
  public TableResultResponse<CompanyPositionVO> pageByCompanyUserId(
      @Valid @RequestBody CompanyPositionPageReqDTO companyPositionPage) {
    TableData<CompanyPositionVO> tableData = positionManager
        .pageByCompanyUserId(companyPositionPage);
    return new TableResultResponse<>(tableData);
  }


}
