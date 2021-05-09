package com.db.chaomaxs.userweb.controller.position.vo;

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




}
