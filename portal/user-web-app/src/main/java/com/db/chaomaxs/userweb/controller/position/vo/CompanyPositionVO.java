package com.db.chaomaxs.userweb.controller.position.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
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
@ApiModel(value = "CompanyPositionVO", description = "公司职位")
public class CompanyPositionVO {

  /**
   * 职位id
   */
  @ApiModelProperty(name = "id", value = "职位id")
  @NotEmpty(message = "职位id")
  private Long id;

  /**
   * 职位名称
   */
  @ApiModelProperty(name = "positionName", value = "职位名称")
  private String positionName;

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
   * 市
   */
  @ApiModelProperty(name = "cityCode", value = "城市编码")
  private String cityCode;

  /**
   * 商圈
   */
  @ApiModelProperty(name = "businessDistrict", value = "商圈")
  private String businessDistrict;
  

}
