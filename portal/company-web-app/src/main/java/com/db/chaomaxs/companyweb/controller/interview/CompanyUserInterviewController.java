package com.db.chaomaxs.companyweb.controller.interview;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.db.chaomaxs.companyweb.controller.interview.dto.CompanyUserInterviewAddDTO;
import com.db.chaomaxs.companyweb.controller.interview.dto.CompanyUserInterviewPageDTO;
import com.db.chaomaxs.companyweb.controller.interview.dto.CompanyUserInterviewUpdateDTO;
import com.db.chaomaxs.companyweb.controller.interview.vo.CompanyUserInterviewVO;
import com.db.chaomaxs.companyweb.manager.interview.CompanyUserInterviewManager;
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
 * 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "企业面试表", description = "企业面试表", tags = "CompanyUserInterview")
@RestController
@RequestMapping("/rest/companyUserInterview")
public class CompanyUserInterviewController {

  @Autowired
  private CompanyUserInterviewManager companyUserInterviewManager;

  /**
   * 添加数据
   *
   * @param companyUserInterviewAddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody CompanyUserInterviewAddDTO companyUserInterviewAddDTO) {
    companyUserInterviewManager.save(companyUserInterviewAddDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param companyUserInterviewUpdateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody CompanyUserInterviewUpdateDTO companyUserInterviewUpdateDTO) {
    companyUserInterviewManager.update(companyUserInterviewUpdateDTO);
    return BaseResponse.success("更新成功");
  }


  /**
   * 更新数据
   *
   * @param companyUserInterviewUpdateStateReqDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/state")
  public BaseResponse updateState(@Valid @RequestBody CompanyUserInterviewUpdateStateReqDTO companyUserInterviewUpdateStateReqDTO) {
    companyUserInterviewManager.updateState(companyUserInterviewUpdateStateReqDTO);
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
  public ObjectRestResponse<CompanyUserInterviewVO> getCompanyUserInterviewById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(companyUserInterviewManager.getCompanyUserInterviewById(id));
  }


  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<CompanyUserInterviewVO> page(@RequestBody CompanyUserInterviewPageDTO pageReqDTO) {
    return companyUserInterviewManager.pageCompanyUserInterview(pageReqDTO);
  }

}
