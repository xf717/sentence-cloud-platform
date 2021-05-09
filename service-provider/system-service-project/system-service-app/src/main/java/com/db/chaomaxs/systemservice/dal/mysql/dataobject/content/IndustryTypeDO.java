package com.db.chaomaxs.systemservice.dal.mysql.dataobject.content;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.BaseDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 行业分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("industry_type")
public class IndustryTypeDO extends BaseDO {

  /**
   * 系统id
   */
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

  /**
   * 是否删除 1:是 0否  默认：0
   */
  @TableLogic
  private Integer isDeleted;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 创建人
   */
  private Long createBy;

  /**
   * 修改时间
   */
  private Date updateTime;

  /**
   * 修改人
   */
  private Long updateBy;


}
