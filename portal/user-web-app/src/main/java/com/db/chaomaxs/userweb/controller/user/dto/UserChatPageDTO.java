package com.db.chaomaxs.userweb.controller.user.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 用户_沟通
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserChatPageDTO", description = "分页:用户_沟通")
public class UserChatPageDTO extends PageParam {

  private static final long serialVersionUID = 1L;

  /**
   * 用户id
   */
  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;


}
