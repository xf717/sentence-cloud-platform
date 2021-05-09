package com.db.chaomaxs.userweb.controller.resume.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyVO",description = "公司名称")
public class CompanyVO {
  @ApiModelProperty(name ="id", value = "公司id")
  private Long id;

  @ApiModelProperty(name ="fullName", value = "公司名称")
  private String fullName;
}
