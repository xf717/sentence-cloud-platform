package com.db.chaomaxs.companyweb.controller.company.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hlf
 * @description: 企业同事转移
 * @date 2021/4/29 14:51
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyColleagueTransferReqDTO", description = "企业同事转移")
public class CompanyColleagueTransferReqDTO {

  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;

  @ApiModelProperty(name = "transferToUserId", value = "移交用户id")
  private Long transferToUserId;

  @ApiModelProperty(name = "companyId", value = "公司id")
  private Long companyId;

}
