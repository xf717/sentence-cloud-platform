package com.github.xf717.managementweb.controller.content.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 内容管理-协议信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "AgreementInformationVO", description = "内容管理-协议信息表")
public class AgreementInformationVO {

  /**
   * 标题
   */
  @ApiModelProperty(name = "keywordTitle", value = "标题")
  private String keywordTitle;
  /**
   * 内容
   */
  @ApiModelProperty(name = "content", value = "内容")
  private String content;


}
