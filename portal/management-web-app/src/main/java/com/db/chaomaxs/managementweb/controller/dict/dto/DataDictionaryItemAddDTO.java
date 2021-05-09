package com.db.chaomaxs.managementweb.controller.dict.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 数据字典项信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "DataDictionaryItemCreateDTO", description = "添加数据字典项信息表")
public class DataDictionaryItemAddDTO {


  /**
   * 字典分类ID
   */
  @ApiModelProperty(name = "dictionaryTypeId", value = "字典分类ID")
  private Long dictionaryTypeId;

  /**
   * 字典项名称
   */
  @ApiModelProperty(name = "dictText", value = "字典项名称")
  @NotNull(message ="字典项名称不能为空" )
  @Size(max = 200, message = "字典项名称最长200个字符")
  private String dictText;

  /**
   * 字典类型编号
   */
  @ApiModelProperty(name = "dictValue", value = "字典类型编号")
  @NotNull(message ="字典类型编号不能为空")
  private String dictValue;

  /**
   * 排序
   */
  @ApiModelProperty(name = "sort", value = "排序")
  private Integer sort;

  /**
   * 启用状态
   */
  @ApiModelProperty(name = "isEnabled", value = "启用状态",example = "1:启用  0:不启用")
  @NotNull(message ="启用状态不能为空" )
  private Integer enabled;


}
