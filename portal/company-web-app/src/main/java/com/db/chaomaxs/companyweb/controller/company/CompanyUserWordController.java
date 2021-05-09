package com.db.chaomaxs.companyweb.controller.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyUserWordAddDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyUserWordDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyUserWordPageDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyUserWordUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyUserWordVO;
import com.db.chaomaxs.companyweb.manager.company.CompanyUserWordManager;
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
 * 企业常用语表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "企业常用语表", description = "企业常用语表", tags = "CompanyUserWord")
@RestController
@RequestMapping("/rest/companyUserWord")
public class CompanyUserWordController {

  @Autowired
  private CompanyUserWordManager companyUserWordManager;

  /**
   * 添加数据
   *
   * @param AddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody CompanyUserWordAddDTO companyUserWordAddDTO) {
    companyUserWordManager.save(companyUserWordAddDTO);
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
      @Valid @RequestBody CompanyUserWordUpdateDTO companyUserWordUpdateDTO) {
    companyUserWordManager.update(companyUserWordUpdateDTO);
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
    companyUserWordManager.remove(id);
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
  public ObjectRestResponse<CompanyUserWordVO> getCompanyUserWordById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(companyUserWordManager.getCompanyUserWordById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<CompanyUserWordVO>> listCompanyUserWords(
      @Valid @RequestBody CompanyUserWordDTO companyUserWordDTO) {
    List<CompanyUserWordVO> list = companyUserWordManager.listCompanyUserWords(companyUserWordDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<CompanyUserWordVO> page(
      @RequestBody CompanyUserWordPageDTO pageReqDTO) {
    return companyUserWordManager.pageCompanyUserWord(pageReqDTO);
  }

}
