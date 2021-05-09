package com.db.chaomaxs.companyweb.controller.position.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 职务职位分类信息表
 *
 * @author ding
 * @date 2021-04-06 17:45:09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "PositionTypeVO", description = "职务职位分类信息表")
public class PositionTypeVO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 分类名称
   */
  @ApiModelProperty(name = "typeName", value = "分类名称")
  private String typeName;


  /**
   * 上级分类ID
   */
  @ApiModelProperty(name = "parentId", value = "上级分类ID")
  private Long parentId;

  /**
   * 显示状态（1显示 0不显示）
   */
  @ApiModelProperty(name = "displayStatus", value = "显示状态（1显示 0不显示）")
  private Integer displayStatus;

  /**
   * 排序
   */
  @ApiModelProperty(name = "sortOrder", value = "排序")
  private Integer sortOrder;


}
