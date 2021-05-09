package com.db.chaomaxs.positionservice.dal.mysql.dataobject.positiontype;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 职务职位分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("position_type")
public class PositionTypeDO extends BaseDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 分类名称
   */
  private String typeName;

  /**
   * 编号  1-2-3
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
   * 显示状态（1显示 0不显示）
   */
  private Integer displayStatus;

  /**
   * 排序
   */
  private Integer sortOrder;

  /**
   * 是否删除 1:是 0否  默认：0
   */
  @TableLogic
  private Integer isDeleted;


}
