package com.db.chaomaxs.managementweb.controller.auth.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class BaseMenuDTO {

  
  /**
   * 标题
   */
  @ApiModelProperty(name = "title", value = "标题", required = true, example = "用户管理")
  @NotNull(message = "标题不能为空")
  private String title;


}
