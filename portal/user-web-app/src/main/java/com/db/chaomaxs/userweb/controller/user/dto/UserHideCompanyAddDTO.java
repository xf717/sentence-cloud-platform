package com.db.chaomaxs.userweb.controller.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 *
 * @author wst
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserHideCompanyCreateDTO", description = "添加用户_屏蔽公司")
public class UserHideCompanyAddDTO {


  /**
   * 项目名称
   */
  @ApiModelProperty(name = "companyName", value = "项目名称")
  private String companyName;

  /**
   * 公司id,做为数据隔离
   */
  @ApiModelProperty(name = "companyId", value = "公司id,做为数据隔离")
  private Long companyId;

}
