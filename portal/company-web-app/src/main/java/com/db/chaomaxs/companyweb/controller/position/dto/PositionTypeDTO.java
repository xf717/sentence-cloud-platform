package com.db.chaomaxs.companyweb.controller.position.dto;

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
public class PositionTypeDTO {


  /**
   * 分类名称
   */
  private String typeName;


  /**
   * 上级分类ID
   */
  private Long parentId;

  /**
   * 显示状态（1显示 0不显示）
   */
  private Integer displayStatus;

  /**
   * 排序
   */
  private Integer sortOrder;


}
