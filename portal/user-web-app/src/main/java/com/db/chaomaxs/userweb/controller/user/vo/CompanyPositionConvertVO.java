package com.db.chaomaxs.userweb.controller.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: CompanyPositionConvertVO
 * @author wst
 * @date 2021/4/20 17:32
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyPositionConvertVO", description = "企业_职位转换vo")
public class CompanyPositionConvertVO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 职位名称
   */
  @ApiModelProperty(name = "positionName", value = "职位名称")
  private String positionName;

  /**
   * 经验要求：关联经验要求表主键id
   */
  @ApiModelProperty(name = "experienceId", value = "经验要求：关联经验要求表主键id")
  private Long experienceId;

  /**
   * 经验要求：冗余字段
   */
  @ApiModelProperty(name = "experience", value = "经验要求：冗余字段")
  private String experience;

  /**
   * 学历ID，字典表主键ID
   */
  @ApiModelProperty(name = "educationId", value = "学历ID，字典表主键ID")
  private Long educationId;

  /**
   * 学历
   */
  @ApiModelProperty(name = "education", value = "学历")
  private String education;

  /**
   * 最低薪资
   */
  @ApiModelProperty(name = "startSalary", value = "最低薪资")
  private Integer startSalary;

  /**
   * 最高薪资
   */
  @ApiModelProperty(name = "endSalary", value = "最高薪资")
  private Integer endSalary;

  /**
   *
   */
  @ApiModelProperty(name = "status", value = "状态")
  private String status;

  /**
   * 区
   */
  @ApiModelProperty(name = "areaCode", value = "区")
  private String areaCode;

  /**
   * 商圈
   */
  @ApiModelProperty(name = "businessDistrict", value = "商圈")
  private String businessDistrict;

  /**
   * 职位关键字
   */
  @ApiModelProperty(name = "keywordList", value = "关键字")
  private List<CompanyPositionKeywordVO> keywordList;
}
