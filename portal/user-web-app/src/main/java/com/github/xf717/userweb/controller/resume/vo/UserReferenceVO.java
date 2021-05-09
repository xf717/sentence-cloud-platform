package com.github.xf717.userweb.controller.resume.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @author wst
 * @date 2021/5/7 16:59
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "UserReferenceVO",description = "用户工作经历参考")
public class UserReferenceVO {

  @ApiModelProperty(name = "content", value = "内容")
  private String content;

  @ApiModelProperty(name = "positionName", value = "职位名称")
  private String positionName;


}
