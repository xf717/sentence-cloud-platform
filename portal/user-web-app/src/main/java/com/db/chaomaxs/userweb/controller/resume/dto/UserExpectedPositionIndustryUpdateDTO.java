package com.db.chaomaxs.userweb.controller.resume.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 用户_期望_职位_行业
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserExpectedPositionIndustryUpdateDTO", description = "更新用户_期望_职位_行业")
public class UserExpectedPositionIndustryUpdateDTO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

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
