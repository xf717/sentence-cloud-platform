package com.db.chaomaxs.companyweb.controller.company.vo;

import com.db.chaomaxs.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hlf
 * @version 1.0
 * @description: 企业同事分页
 * @date 2021/4/29 14:51
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyColleagueVO", description = "企业同事信息")
public class CompanyColleagueVO extends PageParam {

  private static final long serialVersionUID = -1059384461484997009L;

  @ApiModelProperty(name = "id", value = "主键id")
  private Long id;

  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;

  @ApiModelProperty(name = "companyId", value = "企业id")
  private Long companyId;

  @ApiModelProperty(name = "realName", value = "姓名")
  private String realName;

  @ApiModelProperty(name = "manager", value = "是否为管理员， 0-否，1-是")
  private Integer manager;

  @ApiModelProperty(name = "bindingState", value = "绑定状态， 0-未绑定，1-已绑定，2-已解绑")
  private Integer bindingState;

  @ApiModelProperty(name = "email", value = "邮箱")
  private String email;

  @ApiModelProperty(name = "mobile", value = "手机")
  private String mobile;

  @ApiModelProperty(name = "position", value = "职务")
  private String position;

}
