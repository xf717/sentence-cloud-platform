package com.db.chaomaxs.systemservice.rpc.dict.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 字典分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Data
@Accessors(chain = true)
public class DataDictionaryTypeUpdateReqDTO implements Serializable {


  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
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
  private Integer enabled;


  /**
   * 字典编码(默认不能被编辑)
   */
  private String code;


}
