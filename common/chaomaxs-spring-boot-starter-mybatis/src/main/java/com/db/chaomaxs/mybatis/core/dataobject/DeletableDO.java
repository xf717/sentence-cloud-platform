package com.db.chaomaxs.mybatis.core.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

/**
 * extends BaseDO 扩展 delete 操作
 *
 * @author xiaofeng
 * @time 2019-03-22 22:03
 */
public class DeletableDO extends BaseDO {

  /**
   * 是否删除
   */
  @TableLogic
  @TableField("is_deleted")
  private Integer deleted;

  @Override
  public String toString() {
    return "DeletableDO{" +
        "deleted=" + deleted + "  super=" + super.toString() +
        '}';
  }

  public Integer getDeleted() {
    return deleted;
  }

  public DeletableDO setDeleted(Integer deleted) {
    this.deleted = deleted;
    return this;
  }

}
