package com.db.chaomaxs.mybatis.core.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.util.Date;

/**
 * 基础实体对象
 *
 * @author xiaofeng
 */
public class BaseDO {

  /**
   * 创建时间
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  /**
   * 最后更新时间
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;

  /**
   * 创建人
   */
  @TableField(fill = FieldFill.INSERT)
  private Long createBy;

  /**
   * 修改人
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Long updateBy;

  public Date getCreateTime() {
    return createTime;
  }

  public BaseDO setCreateTime(Date createTime) {
    this.createTime = createTime;
    return this;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public BaseDO setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
    return this;
  }

  public Long getCreateBy() {
    return createBy;
  }

  public BaseDO setCreateBy(Long createBy) {
    this.createBy = createBy;
    return this;
  }

  public Long getUpdateBy() {
    return updateBy;
  }

  public BaseDO setUpdateBy(Long updateBy) {
    this.updateBy = updateBy;
    return this;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("BaseDO{");
    sb.append("createTime=").append(createTime);
    sb.append(", updateTime=").append(updateTime);
    sb.append(", createBy=").append(createBy);
    sb.append(", updateBy=").append(updateBy);
    sb.append('}');
    return sb.toString();
  }
}
