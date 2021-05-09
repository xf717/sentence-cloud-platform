package com.db.chaomaxs.systemservice.rpc.content.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
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
public class IndustryTypeUpdateReqDTO implements Serializable {


  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 分类名称
   */
  private String typeName;

  /**
   * 编号
   */
  private String code;

  /**
   * 级别
   */
  private Integer level;

  /**
   * 上级分类ID
   */
  private Long parentId;

  /**
   * 显示状态(1显示 0不显示)
   */
  private Integer displayStatus;

  /**
   * 排序
   */
  private Integer sort;


}
