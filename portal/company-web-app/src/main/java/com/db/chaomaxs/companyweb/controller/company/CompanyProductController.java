package com.db.chaomaxs.companyweb.controller.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyProductAddDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyProductVO;
import com.db.chaomaxs.companyweb.manager.company.CompanyProductManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公司_产品
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "公司_产品", description = "公司_产品", tags = "CompanyProduct")
@RestController
@RequestMapping("/rest/companyProduct")
public class CompanyProductController {

  @Autowired
  private CompanyProductManager companyProductManager;

  /**
   * 保存公司产品信息
   *
   * @param companyProductAddDTOs
   * @return
   */
  @ApiOperation(value = "保存公司产品信息", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody List<CompanyProductAddDTO> companyProductAddDTOs) {
    companyProductManager.save(companyProductAddDTOs);
    return BaseResponse.success("保存成功");
  }

  @ApiOperation(value = "公司产品列表", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<CompanyProductVO>> listProducts() {
    List<CompanyProductVO> list = companyProductManager.listProducts();
    return ObjectRestResponse.success(list);
  }

}
