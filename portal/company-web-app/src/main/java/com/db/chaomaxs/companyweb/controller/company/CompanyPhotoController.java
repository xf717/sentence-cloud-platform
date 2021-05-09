package com.db.chaomaxs.companyweb.controller.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyPhotoAddDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyPhotoVO;
import com.db.chaomaxs.companyweb.manager.company.CompanyPhotoManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公司_相册
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "公司_相册", description = "公司_相册", tags = "CompanyPhoto")
@RestController
@RequestMapping("/rest/companyPhoto")
public class CompanyPhotoController {

  @Autowired
  private CompanyPhotoManager companyPhotoManager;

  /**
   * 保存公司相册
   *
   * @param AddDTO
   * @return
   */
  @ApiOperation(value = "保存公司相册", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody List<CompanyPhotoAddDTO> companyPhotoAddDTOs) {
    companyPhotoManager.save(companyPhotoAddDTOs);
    return BaseResponse.success("保存成功");
  }

  /**
   * 获取公司相册
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "获取公司相册", produces = "application/json", nickname = "getByCompanyId")
  @GetMapping("/get-by-companyId")
  public ObjectRestResponse<List<CompanyPhotoVO>> getByCompanyId() {
    return ObjectRestResponse.success(companyPhotoManager.getByCompanyId());
  }
}
