package com.db.chaomaxs.companyweb.controller.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 公司福利
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyWelfareVO", description = "公司福利")
public class CompanyWelfareVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 福利名称
   */
  @ApiModelProperty(name = "name", value = "福利名称")
  private String name;

  /**
   * 图标url
   */
  @ApiModelProperty(name = "iconUrl", value = "图标url")
  private String iconUrl;

  /**
   * 福利类型：0.通用 1.自定义福利 默认：0
   */
  @ApiModelProperty(name = "welfareType", value = "福利类型：0.通用 1.自定义福利 默认：0")
  private Integer welfareType;

  /**
   * 是否选中，1是 0否 默认：0
   */
  @ApiModelProperty(name = "choose", value = "是否选中，1是 0否 默认：0")
  private Integer choose;




}
