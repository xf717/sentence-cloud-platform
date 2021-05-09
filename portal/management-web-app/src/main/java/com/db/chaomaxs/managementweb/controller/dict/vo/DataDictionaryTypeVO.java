package com.db.chaomaxs.managementweb.controller.dict.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 字典分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "DataDictionaryTypeVO", description = "字典分类信息表")
public class DataDictionaryTypeVO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 字典类型名称
   */
  @ApiModelProperty(name = "dictName", value = "字典类型名称")
  private String dictName;

  /**
   * 字典类型编号
   */
  @ApiModelProperty(name = "dictCode", value = "字典类型编号")
  private String dictCode;

  /**
   * 排序
   */
  @ApiModelProperty(name = "sort", value = "排序")
  private Integer sort;

  /**
   * 启用状态(1 启用 0不启用)
   */
  @ApiModelProperty(name = "isEnabled", value = "启用状态(1 启用 0不启用)")
  private Integer isEnabled;


}
