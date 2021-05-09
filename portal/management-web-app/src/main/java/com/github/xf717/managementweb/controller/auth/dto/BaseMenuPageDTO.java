package com.github.xf717.managementweb.controller.auth.dto;

import com.github.xf717.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "BaseMenuPageDTO", description = "分页:")
public class BaseMenuPageDTO extends PageParam {

  private static final long serialVersionUID = 4518461444841298217L;
  /**
   * 标题
   */
  @ApiModelProperty(name = "title", value = "标题", required = true, example = "用户管理")
  @NotNull(message = "标题不能为空")
  private String title;


}
