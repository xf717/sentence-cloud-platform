package com.db.chaomaxs.companyweb.controller.company.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 公司端_注册
 *
 * @author hlf
 * @date 2021-04-19 16:03:23
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyRegisterReqDto", description = "pc端_注册公司")
public class CompanyRegisterReqDto {

  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;

  @ApiModelProperty(name = "realName", value = "姓名")
  private String realName;

  @ApiModelProperty(name = "position", value = "职务")
  private String position;

  @ApiModelProperty(name = "email", value = "邮箱")
  private String email;

  @ApiModelProperty(name = "fullName", value = "公司全称")
  private String fullName;

  @ApiModelProperty(name = "shortName", value = "公司简称")
  private String shortName;

  @ApiModelProperty(name = "industryId", value = "所属行业id,关联行业字典表id")
  private Long industryId;

  @ApiModelProperty(name = "industryName", value = "所属行业名称,冗余字段")
  private String industryName;

  @ApiModelProperty(name = "provinceName", value = "省名称")
  private String provinceName;

  @ApiModelProperty(name = "provinceCode", value = "省编号")
  private String provinceCode;

  @ApiModelProperty(name = "cityName", value = "市名称")
  private String cityName;

  @ApiModelProperty(name = "cityCode", value = "市编号")
  private String cityCode;

  @ApiModelProperty(name = "areaName", value = "区名称")
  private String areaName;

  @ApiModelProperty(name = "areaCode", value = "区编号")
  private String areaCode;

  @ApiModelProperty(name = "address", value = "详细地址")
  private String address;

  @ApiModelProperty(name = "scopeDictionaryId", value = "公司规模,关联数据字典表id")
  private Long scopeDictionaryId;

  @ApiModelProperty(name = "developmentStageDictionaryId", value = "发展阶段")
  private Long developmentStageDictionaryId;

  @ApiModelProperty(name = "licenseUrl", value = "营业执照图片地址")
  private String licenseUrl;
}
