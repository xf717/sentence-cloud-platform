package com.db.chaomaxs.userweb.controller.resume.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 用户_附件_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserEnclosureResumeUpdateDTO", description = "更新用户_附件_简历")
public class UserEnclosureResumeUpdateDTO {

  /**
   * 主键Id
   */
  @ApiModelProperty(name = "id", value = "主键Id")
  private Long id;

  /**
   * 附件资源ID
   */
  @ApiModelProperty(name = "resourceId", value = "附件资源ID")
  private Long resourceId;

  /**
   * 附件资源ID
   */
  @ApiModelProperty(name = "resourceId", value = "附件资源ID")
  private String resumeName;


}
