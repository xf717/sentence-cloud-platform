package com.github.xf717.systemservice.rpc.dict.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 数据字典项信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@Accessors(chain = true)
public class DataDictionaryItemUpdateReqDTO implements Serializable {


  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
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
  private Integer enabled;


}
