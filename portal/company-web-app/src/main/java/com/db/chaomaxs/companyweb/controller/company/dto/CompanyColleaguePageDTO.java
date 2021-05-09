package com.db.chaomaxs.companyweb.controller.company.dto;

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
@ApiModel(value = "CompanyColleaguePageDTO", description = "企业同事分页")
public class CompanyColleaguePageDTO extends PageParam {

  private static final long serialVersionUID = -2030000711146277424L;
  @ApiModelProperty(name = "bindingState", value = "绑定状态， 0-未绑定，1-已绑定，2-已解绑")
  private Integer bindingState;

}
