package com.github.xf717.userweb.controller.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_屏蔽公司
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserHideCompanyVO", description = "用户_屏蔽公司")
public class UserHideCompanyVO {

  /**
   * 屏蔽的公司id
   */
  @ApiModelProperty(name = "id", value = "屏蔽的公司id")
  private Long id;

  /**
   * 项目名称
   */
  @ApiModelProperty(name = "companyName", value = "项目名称")
  private String companyName;


}
