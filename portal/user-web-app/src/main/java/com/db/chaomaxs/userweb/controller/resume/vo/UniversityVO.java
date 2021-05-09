package com.db.chaomaxs.userweb.controller.resume.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: 高校名称
 * @author wst
 * @date 2021/5/6 14:42
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "UniversityVO",description = "高校名称")
public class UniversityVO {

  @ApiModelProperty(name ="id", value = "高校字典id")
  private Long id;

  @ApiModelProperty(name ="dictText", value = "高校名称")
  private String dictText;

}
