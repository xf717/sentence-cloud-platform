package com.db.chaomaxs.companyweb.controller.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hlf
 * @version 1.0
 * @description: 公司福利信息
 * @date 2021/4/27 14:52
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyWelfareInfoVO", description = "公司福利信息")
public class CompanyWelfareInfoVO {

  /**
   * 公司福利类型list
   */
  @ApiModelProperty(name = "companyWelfareVOs", value = "公司福利类型list")
  private List<CompanyWelfareVO> companyWelfareVOs;

  /**
   * 选中数量
   */
  @ApiModelProperty(name = "chooseNumber", value = "选中数量")
  private Integer chooseNumber;
}
