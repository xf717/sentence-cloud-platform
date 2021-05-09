package com.db.chaomaxs.userweb.controller.position.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业_职位
 *
 * @author xiaofeng
 * @date 2021-04-28 16:57:09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "PositionVO", description = "职位详情信息")
public class PositionVO {

  /**
   * 职位名称
   */
  @ApiModelProperty(name = "positionName", value = "职位名称")
  private String positionName;


  /**
   * 职位类别
   */
  @ApiModelProperty(name = "positionTypeName", value = "职位类别名")
  private Long positionTypeName;

  /**
   * 省份
   */
  @ApiModelProperty(name = "provinceCode", value = "省份")
  private String provinceCode;

  /**
   * 城市
   */
  @ApiModelProperty(name = "cityCode", value = "城市")
  private String cityCode;

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
   * 经验要求
   */
  @ApiModelProperty(name = "experience", value = "经验要求")
  private String experience;

  /**
   * 学历
   */
  @ApiModelProperty(name = "education", value = "学历")
  private String education;

  /**
   * 学历
   */
  @ApiModelProperty(name = "companyName", value = "企业名称")
  private String companyName;

  /**
   * 企业名称
   */
  @ApiModelProperty(name = "createName", value = "创建人")
  private String createName;

  /**
   * 企业名称
   */
  @ApiModelProperty(name = "createTime", value = "创建时间")
  private String createTime;

  /**
   * 发布状态
   */
  @ApiModelProperty(name = "status", value = "发布状态")
  private String status;


}
