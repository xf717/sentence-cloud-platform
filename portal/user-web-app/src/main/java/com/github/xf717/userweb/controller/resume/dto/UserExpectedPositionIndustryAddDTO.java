package com.github.xf717.userweb.controller.resume.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserExpectedPositionIndustryCreateDTO", description = "添加用户_期望_职位_行业")
public class UserExpectedPositionIndustryAddDTO {


  /**
   * 期望职位id，关联期望职位表id
   */
  @ApiModelProperty(name = "expectedPositionId", value = "期望职位id，关联期望职位表id")
  private Long expectedPositionId;

  /**
   * 期望行业id,关联行业字典表id
   */
  @ApiModelProperty(name = "industryId", value = "期望行业id,关联行业字典表id")
  private Long industryId;

  /**
   * 期望行业名称,冗余字段
   */
  @ApiModelProperty(name = "industryName", value = "期望行业名称,冗余字段")
  private String industryName;

}
