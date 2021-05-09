package com.db.chaomaxs.userweb.controller.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @description: 批量添加用户_屏蔽公司
 * @author wst
 * @date 2021/4/29 14:13
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "UserHideCompanyBatchInsertDTO", description = "批量添加用户_屏蔽公司")
public class UserHideCompanyBatchInsertDTO {

  @ApiModelProperty(name = "hideCompanyList", value = "隐藏公司集合")
  private List<UserHideCompanyAddDTO> hideCompanyList;
}
