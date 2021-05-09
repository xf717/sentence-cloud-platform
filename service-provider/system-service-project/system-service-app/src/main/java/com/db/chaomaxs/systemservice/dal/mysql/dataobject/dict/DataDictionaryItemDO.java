package com.db.chaomaxs.systemservice.dal.mysql.dataobject.dict;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 数据字典项信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("data_dictionary_item")
public class DataDictionaryItemDO extends DeletableDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 字典分类ID
   */
  private Long dictionaryTypeId;

  /**
   * 字典项名称
   */
  private String dictText;

  /**
   * 字典类型编号
   */
  private String dictValue;

  /**
   * 排序
   */
  private Integer sort;

  /**
   * 启用状态
   */
  @TableField("is_enabled")
  private Integer enabled;




}
