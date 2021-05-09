package com.github.xf717.managementweb.controller.content.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 内容管理-问题信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ProblemInformationVO", description = "内容管理-问题信息表")
public class ProblemInformationVO {

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
   * 发布状态string
   */
  @ApiModelProperty(name = "releaseStatusStr", value = "发布状态(已发布,待发布)   ")
  private String releaseStatusStr;

  /**
   * 排序
   */
  @ApiModelProperty(name = "sort", value = "排序")
  private Integer sort;


  /**
   * 创建时间
   */
  @ApiModelProperty(name = "createTime", value = "创建时间")
  private Date createTime;

  /**
   * 创建人
   */
  @ApiModelProperty(name = "createBy", value = "创建人")
  private Long createBy;

  /**
   * 创建人姓名
   */
  @ApiModelProperty(name = "createName", value = "创建人姓名")
  private String createName;

  /**
   * 平台
   */
  @ApiModelProperty(name = "platform", value = "平台  1:求职端　2:企业端")
  private Integer platform;

  /**
   * 平台string
   */
  @ApiModelProperty(name = "platform", value = "求职端　企业端")
  private String platformStr;


}
