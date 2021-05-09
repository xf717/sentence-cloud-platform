package com.db.chaomaxs.companyweb.controller.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 数据字典项信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "DictionaryItemVO", description = "数据字典项信息表")
public class DictionaryItemVO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 字典分类ID
   */
  @ApiModelProperty(name = "dictionaryTypeId", value = "字典分类ID")
  private Long dictionaryTypeId;

  /**
   * 字典项名称
   */
  @ApiModelProperty(name = "dictText", value = "字典项名称")
  private String dictText;

  /**
   * 字典类型编号
   */
  @ApiModelProperty(name = "dictValue", value = "字典类型编号")
  private String dictValue;

  /**
   * 排序
   */
  @ApiModelProperty(name = "sort", value = "排序")
  private Integer sort;

  /**
   * 启用状态
   */
  @ApiModelProperty(name = "isEnabled", value = "启用状态")
  private Integer isEnabled;


}
