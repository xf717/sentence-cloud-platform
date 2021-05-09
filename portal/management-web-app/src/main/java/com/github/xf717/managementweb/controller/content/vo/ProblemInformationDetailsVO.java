package com.github.xf717.managementweb.controller.content.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 内容管理-问题详细信息
 *
 * @author ding
 * @date 2021-04-15
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ProblemInformationDetailsVO", description = "内容管理-问题详细信息")
public class ProblemInformationDetailsVO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 问题标题
   */
  @ApiModelProperty(name = "title", value = "问题标题")
  private String title;

  /**
   * 问题类型,关联字典表id
   */
  @ApiModelProperty(name = "typeDictionaryId", value = "问题类型,关联字典表id")
  private Long typeDictionaryId;

  /**
   * 问题类型
   */
  @ApiModelProperty(name = "typeDictionary", value = "问题类型")
  private String typeDictionary;

  /**
   * 发布状态  是否发布  1:是 0否
   */
  @ApiModelProperty(name = "releaseStatus", value = "发布状态  是否发布  1:是 0否  ")
  private Integer releaseStatus;

  /**
   * 排序
   */
  @ApiModelProperty(name = "sort", value = "排序")
  private Integer sort;


  /**
   * 平台
   */
  @ApiModelProperty(name = "platform", value = "平台  1:求职端　2:企业端")
  private Integer platform;


  /**
   * 问题内容扩展表id
   */
  @ApiModelProperty(name = "informationExtendId", value = "问题内容扩展表id")
  private Long informationExtendId;

  /**
   * 问题内容
   */
  @ApiModelProperty(name = "content", value = "content")
  private String content;


}
