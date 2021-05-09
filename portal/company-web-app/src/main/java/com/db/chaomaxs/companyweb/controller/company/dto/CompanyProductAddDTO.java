package com.db.chaomaxs.companyweb.controller.company.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 公司_产品
 *
 * @author hlf
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyProductCreateDTO", description = "添加公司_产品")
public class CompanyProductAddDTO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 企业公司id
   */
  @ApiModelProperty(name = "companyId", value = "企业公司id")
  private Long companyId;

  /**
   * 产品图片存储地址
   */
  @ApiModelProperty(name = "logoUrl", value = "产品图片存储地址")
  private String logoUrl;

  /**
   * 产品名称
   */
  @ApiModelProperty(name = "productName", value = "产品名称")
  private String productName;

}
