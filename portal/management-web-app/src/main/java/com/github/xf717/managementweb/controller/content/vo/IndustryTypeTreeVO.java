package com.github.xf717.managementweb.controller.content.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 行业分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "IndustryTypeTreeVO", description = "行业分类树型信息")
public class IndustryTypeTreeVO  implements Serializable {

  private static final long serialVersionUID = -1393952757327186450L;
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
   * 子分类
   */
  @ApiModelProperty(name = "children", value = "子分类")
  private List<IndustryTypeTreeVO> children ;



}
