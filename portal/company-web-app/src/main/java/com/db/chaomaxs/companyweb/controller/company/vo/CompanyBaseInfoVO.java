package com.db.chaomaxs.companyweb.controller.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hlf
 * @version 1.0
 * @description: TODO
 * @date 2021/4/23 16:36
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyBaseInfoVo", description = "公司主页基本信息")
public class CompanyBaseInfoVO implements Serializable {

  private static final long serialVersionUID = 3866501736046556710L;
  /**
   * 主键id
   */
  @ApiModelProperty(name = "id", value = "主键id")
  private Long id;

  /**
   * 用户id
   */
  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;

  /**
   * 企业LOGO图片地址
   */
  @ApiModelProperty(name = "logoUrl", value = "企业LOGO图片地址")
  private String logoUrl;

  /**
   * 所属行业名称,冗余字段
   */
  @ApiModelProperty(name = "industryName", value = "所属行业名称,冗余字段")
  private String industryName;

  /**
   * 公司全称
   */
  @ApiModelProperty(name = "fullName", value = "公司全称")
  private String fullName;

  /**
   * 公司模块名称
   */
  @ApiModelProperty(name = "scopeDictionaryName", value = "公司模块名称")
  private String scopeDictionaryName;

  /**
   * 发展阶段名称
   */
  @ApiModelProperty(name = "developmentStageDictionaryName", value = "发展阶段名称")
  private String developmentStageDictionaryName;

  /**
   * 营业执照图片地址
   */
  @ApiModelProperty(name = "licenseUrl", value = "营业执照图片地址")
  private String licenseUrl;
}
