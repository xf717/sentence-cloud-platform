package com.db.chaomaxs.companyweb.controller.position.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: 职位分类树型信息
 * @author wst
 * @date 2021/5/6 14:06
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "PositionTypeTreeVO", description = "职位分类树型信息")
public class PositionTypeTreeVO  implements Serializable {

  private static final long serialVersionUID = -4540322048726855075L;
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
  @ApiModelProperty(name = "children",value = "子分类")
  private List<PositionTypeTreeVO> children;

}
