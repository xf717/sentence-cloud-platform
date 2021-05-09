package com.github.xf717.userweb.controller.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: CompanyPositionKeywordVo
 * @author wst
 * @date 2021/4/20 17:27
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyPositionKeywordVo", description = "企业_职位关键字")
public class CompanyPositionKeywordVO {
  /**
   * 职位关键字id
   */
  @ApiModelProperty(name = "positionKeywordId", value = "职位关键字id")
  private Long positionKeywordId;

  /**
   * 职位关键字名称
   */
  @ApiModelProperty(name = "keywordTitle", value = "职位关键字名称")
  private String keywordTitle;

}
