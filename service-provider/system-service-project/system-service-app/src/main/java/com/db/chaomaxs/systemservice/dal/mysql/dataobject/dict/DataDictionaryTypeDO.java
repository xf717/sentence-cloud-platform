package com.db.chaomaxs.systemservice.dal.mysql.dataobject.dict;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 字典分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("data_dictionary_type")
public class DataDictionaryTypeDO extends DeletableDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 字典类型名称
   */
  private String dictName;

  /**
   * 字典类型编号
   */
  private String dictCode;

  /**
   * 排序
   */
  private Integer sort;

  /**
   * 启用状态(1 启用 0不启用)
   */
  @TableField("is_enabled")
  private Integer enabled;



  /**
   * 字典编码(默认不能被编辑)
   */
  private  String code;


}
