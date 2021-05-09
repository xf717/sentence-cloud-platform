package com.github.xf717.userweb.controller.position.dto;

import com.github.xf717.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 职位搜索请求参数
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/28 15:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "CompanyPositionPageReqDTO", description = "公司职位")
public class CompanyPositionPageReqDTO extends PageParam {

  private static final long serialVersionUID = -6719997576793430495L;

  @ApiModelProperty(value = "公司用户id", example = "1")
  @Min(value = 1, message = "最小值为1")
  private Long companyUserId;


}
